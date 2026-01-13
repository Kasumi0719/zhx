import java.util.HashMap;
import java.util.Map;

public class q13 {
    static Map<Character, Integer> mapping = new HashMap<>();

    static {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                if(i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')){
                    res += mapping.get(s.charAt(i + 1)) - mapping.get(s.charAt(i));
                    i++;
                } else {
                    res += mapping.get(s.charAt(i));
                }
            } else if(s.charAt(i) == 'X') {
                if(i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')){
                    res += mapping.get(s.charAt(i + 1)) - mapping.get(s.charAt(i));
                    i++;
                } else {
                    res += mapping.get(s.charAt(i));
                }
            } else if(s.charAt(i) == 'C'){
                if(i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')){
                    res += mapping.get(s.charAt(i + 1)) - mapping.get(s.charAt(i));
                    i++;
                } else {
                    res += mapping.get(s.charAt(i));
                }
            } else {
                res += mapping.get(s.charAt(i));
            }
        }
        return res;
    }
}
