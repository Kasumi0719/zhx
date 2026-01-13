import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q76 {
    Map<Character, Integer> target = new HashMap<>();

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int resLeft = 0;
        int resRight = Integer.MAX_VALUE;
        for(int i = 0; i < t.length(); i++) target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        int diffNum = target.size();
        for(; right < s.length(); right++){
            if(target.containsKey(s.charAt(right))){
                target.put(s.charAt(right), target.getOrDefault(s.charAt(right), 0) - 1);
                if(target.get(s.charAt(right)) == 0) diffNum--;
                if(diffNum == 0){
                    for(; left <= right; left++){
                        if(target.containsKey(s.charAt(left))){
                            target.put(s.charAt(left), target.getOrDefault(s.charAt(left), 0) + 1);
                            if(target.get(s.charAt(left)) > 0){
                                diffNum++;
                                if(right - left < resRight - resLeft){
                                    resLeft = left; resRight = right;
                                }
                                left++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return getSubString(s, resLeft, resRight);
    }

    public String getSubString(String s, int left, int right) {
        if (right == Integer.MAX_VALUE) return "";
        StringBuilder res = new StringBuilder();
        for(int i = left; i <= right; i++) res.append(s.charAt(i));
        return res.toString();
    }
}
