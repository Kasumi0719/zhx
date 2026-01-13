import java.util.ArrayList;
import java.util.List;

public class q2266 {
    int count = 0;
    long result = 1;
    public int countTexts(String pressedKeys) {
        List<Character> recordChar = new ArrayList<>();
        List<Integer> recordNum = new ArrayList<>();
        for (int i = 0; i < pressedKeys.length(); i++){
            if (recordChar.isEmpty() || recordChar.get(recordChar.size() - 1) != pressedKeys.charAt(i)){
                recordChar.add(pressedKeys.charAt(i));
                recordNum.add(1);
            }else{
                recordNum.set(recordNum.size() - 1, recordNum.get(recordNum.size() - 1) + 1);
            }
        }
        for (int i = 0; i < recordNum.size(); i++){
            count = 0;
            getCount(recordChar.get(i), recordNum.get(i), 0);
            result *= count;
        }
        return (int) (result % ((long) Math.pow(10, 9) + 7));
    }

    public void getCount(char key, int num, int index) {
        int cyclic = 3;
        if(index == num){
            count += 1;
            return ;
        }else if(index > num){
            return ;
        }
        if(key == '9' || key == '7') cyclic = 4;

        for(int i = 1; i <= cyclic; i++){
            index += i;
            getCount(key, num, index);
            index -= i;
        }
        return ;
    }
}
