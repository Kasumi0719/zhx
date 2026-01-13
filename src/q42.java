import java.util.HashSet;
import java.util.Set;

public class q42 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> record = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int result = 0;
        for(; right < s.length(); right++) {
            if(!record.contains(s.charAt(right))){
                record.add(s.charAt(right));
                right++;
            }else{
                result = Math.max(result, right - left);
                while(s.charAt(left) != s.charAt(right)){
                    record.remove(s.charAt(left++));
                }
            }
        }
        return result;
    }
}
