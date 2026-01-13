public class q55 {
    public boolean canJump(int[] nums) {
        int start = 0;
        int maxLen = nums[start];
        while (start <= maxLen) {
            maxLen = Math.max(maxLen, start + nums[start]);
            if(maxLen >= nums.length - 1) return true;
        }
        return false;
    }
}
