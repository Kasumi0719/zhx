import java.util.HashSet;
import java.util.Set;

public class q1695 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> record = new HashSet<>();
        int sum = 0;
        int result = 0;
        int left = 0, right = 0;
        for(; left < nums.length; left++){
            while(right < nums.length && !record.contains(nums[right])){
                record.add(nums[right]);
                sum += nums[right];
                right++;
            }
            result = Math.max(result, sum);
            while(nums[left] != nums[right]){
                record.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            record.remove(nums[left]);
            sum -= nums[left];
            left++;
        }
        return result;
    }
}
