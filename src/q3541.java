import java.util.HashMap;
import java.util.Map;

public class q3541 {
    public static Map<Character, Integer> meta = new HashMap<>();

    static {
        meta.put('a', 0); meta.put('e', 0); meta.put('i', 0); meta.put('o', 0); meta.put('u', 0);
    }

    public static int maxFreqSum(String s) {
        Map<Character, Integer> record = new HashMap<>();
        Map<Character, Integer> nonRecord = new HashMap<>();
        int metaCount = 0;
        int nonMetaCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(meta.containsKey(c)) {
                meta.put(c, meta.get(c) + 1);
                metaCount = Math.max(metaCount, meta.get(c));
            } else {
                nonRecord.put(c, nonRecord.getOrDefault(c, 0) + 1);
                nonMetaCount = Math.max(nonMetaCount, nonRecord.get(c));
            }
        }
        return nonMetaCount + metaCount;
    }

    public static void main(String[] args) {
        String input = "aeiaeia";
        System.out.println(maxFreqSum(input));
    }
}
