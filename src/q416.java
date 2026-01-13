public class q416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        int[] dp = new int[sum / 2];
        for(int i = 0; i < nums.length; i++){
            for(int j = sum / 2 - 1; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum / 2 - 1] == sum / 2;
    }
}
