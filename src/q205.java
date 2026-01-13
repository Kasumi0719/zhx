import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q205 {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> record = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!record.containsKey(s.charAt(i))){
                if(set.contains(t.charAt(i))) return false;
                record.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            } else {
                if(record.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s,t));
    }
}
