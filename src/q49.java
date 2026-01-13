import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> recordAll = new HashMap<>();
        for (String str : strs){
            List<String> record = recordAll.getOrDefault(getKey(str), new ArrayList<>());
            record.add(str);
            recordAll.put(getKey(str), record);
        }
        return new ArrayList<>(recordAll.values());
    }

    public String getKey(String str){
        int[] record = new int[26];
        for(int i = 0; i < str.length(); i++){
            record[str.charAt(i) - 'a'] += 1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 26; i++){

            sb.append(record[i]);
        }
        return sb.toString();
    }
}
