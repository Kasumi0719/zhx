import java.util.HashMap;
import java.util.Map;

public class q3583 {
    public int specialTriplets(int[] nums) {
        int len = nums.length;
        int MOD = 1_000_000_007;
        long res = 1;
        Map<Integer, Integer> recordLeft = new HashMap<>();
        Map<Integer, Integer> recordRight = new HashMap<>();
        int[] sumLeft = new int[len];
        int[] sumRight = new int[len];
        for(int i = 0; i < len; i++){
            sumLeft[i] = recordLeft.getOrDefault(2 * nums[i], 0);
            sumRight[len - 1 - i] = recordRight.getOrDefault(2 * nums[len - 1 - i], 0);
            recordLeft.put(nums[i], recordLeft.getOrDefault(nums[i], 0) + 1);
            recordRight.put(nums[len - 1 - i], recordRight.getOrDefault(nums[len - 1 - i], 0) + 1);
        }
        for(int i = 0; i < len; i++){
            res += (long) sumLeft[i] * sumRight[len - i - 1];
            res %= MOD;
        }
        return (int) res;
    }
}
