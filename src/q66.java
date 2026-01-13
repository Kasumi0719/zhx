import java.util.Stack;

public class q66 {
    public void plusOne(int[] digits) {
        int overflow = 0;
        int release = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : digits) stack.push(i);
        for(int i = 0; i < digits.length; i++) {
            int popNum = stack.pop();
            if(i == 0){
                overflow = (popNum + 1) / 10;
                release = (popNum + 1) % 10;
            }else{
                overflow = (popNum + overflow) / 10;
                release = (popNum + 1) % 10;
            }
            result += (int) Math.pow(10, i);
        }
    }
}
