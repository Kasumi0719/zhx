import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class q301 {
    int count = 0;

    Map<Integer, Integer> record = new HashMap<>();

    public int beautifulSubsets(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            record.put(nums[i], 1);
            count += 1;
            passThrough(nums, k, i + 1);
            record.remove(nums[i]);
        }
        return count;
    }

    public void passThrough(int[] nums, int k, int index) {
        for (int i = index; i < nums.length; i++) {
            if (record.containsKey(nums[i] - k) || record.containsKey(nums[i] + k)) continue;
            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
            count += 1;
            passThrough(nums, k, i + 1);
            record.put(nums[i], record.getOrDefault(nums[i], 0) - 1);
            if(record.get(nums[i]) == 0) record.remove(nums[i]);
        }
        return ;
    }
}
