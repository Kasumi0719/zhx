import java.util.HashMap;
import java.util.Map;

public class q560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += record.getOrDefault(sum - k, 0);
            record.put(sum, record.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
