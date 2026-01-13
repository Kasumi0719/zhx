import java.util.HashMap;
import java.util.Map;

public class q2506 {
    Map<String, Integer> record = new HashMap<>();

    public int similarPairs(String[] words) {
        int result = 0;
        for(String word : words) putString(word);
        for(Map.Entry<String, Integer> word : record.entrySet()) result += (word.getValue() - 1) * word.getValue() / 2;
        return result;
    }

    public void putString(String words) {
        int[] arr = new int[24];
        for(int i = 0; i < words.length(); i++){
            if(arr[i - 'a'] == 0) arr[i - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr) sb.append(i);
        String str = sb.toString();
        record.put(str, record.getOrDefault(str, 0) + 1);
        return ;
    }
}
