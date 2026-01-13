import java.util.Stack;

public class q1323 {
    public int maximum69Number (int num) {
        Stack<Integer> record = new Stack<>();
        while(num > 0){
            record.push(num % 10);
            num /= 10;
        }
        int res = 0;
        boolean has = false;
        while(!record.isEmpty()){
            int cur = record.pop();
            if(cur == 6 && !has){
                res += (int) Math.pow(10, record.size()) * 9;
                has = true;
            }else{
                res += (int) Math.pow(10, record.size()) * cur;
            }
        }
        return res;
    }
}
