import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
            if(map.get(p.charAt(i)) == 0) map.remove(p.charAt(i));
            if(map.isEmpty()) res.add(i);
        }
        for(int i = p.length(); i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            map.put(s.charAt(i - p.length()), map.getOrDefault(s.charAt(i - p.length()), 0) + 1);
            if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
            if(map.get(s.charAt(i - p.length())) == 0) map.remove(s.charAt(i - p.length()));
            if(map.isEmpty()) res.add(i);
        }
        return res;
    }
}
