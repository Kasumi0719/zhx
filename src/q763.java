import java.util.*;

public class q763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> record = new HashMap<>();
        Map<Character, Integer> passMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) record.put(s.charAt(i), record.getOrDefault(s.charAt(i), 0) + 1);
        int sizeAll = record.size();
        int last = -1;
        List<Integer> result = new ArrayList<>();
        result.toArray();
        for(int i = 0; i < s.length(); i++){
            passMap.put(s.charAt(i), passMap.getOrDefault(s.charAt(i), 0) + 1);
            record.put(s.charAt(i), record.getOrDefault(s.charAt(i), 0) - 1);
            if(record.get(s.charAt(i)) == 0) record.remove(s.charAt(i));
            if(record.size() + passMap.size() == sizeAll && i != 0){
                result.add(i - last);
                last = i;
            }
        }
        return result;
    }
}
