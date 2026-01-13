import java.util.PriorityQueue;

public class q45 {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0;
        int right = nums[0];
        int count = 0;
        int maxLen = 0;
        while(left < nums.length) {
            count++;
            if(right >= nums.length - 1) return count;
            for(; left <= right; left++){
                maxLen = Math.max(nums[left] + left, maxLen);
            }
            right = maxLen;
        }
        return count + 1;
    }
}
