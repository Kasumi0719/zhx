import java.util.HashMap;
import java.util.Map;

public class question1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(record.containsKey(target - i)){
                result[0] = record.get(target - i);
                result[1] = i;
                return result;
            }
            record.put(nums[i], i);
        }
        return result;
    }
}
