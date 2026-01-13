import java.util.HashMap;
import java.util.Map;

public class q904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> record = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        for(; right < fruits.length; right++){
            if(record.containsKey(fruits[right]) || record.size() <= 1){
                record.put(fruits[right], record.getOrDefault(fruits[right], 0) + 1);
                res = Math.max(res, right - left + 1);
            } else {
                while(record.size() == 2){
                    record.put(fruits[left], record.get(fruits[left]) - 1);
                    if(record.get(fruits[left]) == 0){
                        record.remove(fruits[left]);
                    }
                    left++;
                }
                record.put(fruits[right], record.getOrDefault(fruits[right], 0) + 1);
            }
        }
        return Math.max(res, fruits.length - left);
    }
}
