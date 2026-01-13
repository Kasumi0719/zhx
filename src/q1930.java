import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q1930 {
    public static int countPalindromicSubsequence(String s) {
        int res = 0;
        Map<Character, Integer> record = new HashMap<>();
        HashSet<Character> passed = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!record.containsKey(s.charAt(i))) record.put(s.charAt(i), i);
        }
        for(int i = s.length() - 1; i >= 0; i--){
            if(passed.contains(s.charAt(i))) continue;
            int start = record.get(s.charAt(i));
            if(start == i || start == i - 1) continue;
            Set<Character> temp = new HashSet<>();
            for(int j = start + 1; j < i; j++){
                if(temp.contains(s.charAt(j))) continue;
                temp.add(s.charAt(j));
                res += 1;
            }
            passed.add(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "ckafnafqo";
        System.out.println(countPalindromicSubsequence(test));
    }
}
