public class q1590 {
    public static int minSubarray(int[] nums, int p) {
        long[] frontCount = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) frontCount[i] = frontCount[i - 1] + nums[i - 1];

        if(frontCount[nums.length] < p) return -1;

        long target = frontCount[nums.length] % p;
        int maxLen = Integer.MAX_VALUE;

        if(target == 0) return 0;

        for(int i = 1; i <= nums.length; i++){
            int indexMin = Math.max(0, i - maxLen);
            for(int index = i - 1; index >= indexMin; index--){
                if((frontCount[i] - frontCount[index]) % p == target){
                    maxLen = i - index;
                    break;
                }
            }
        }
        return maxLen == Integer.MAX_VALUE ? -1 : maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1000000000,1000000000,1000000000};
        int p = 3;
        System.out.println(minSubarray(nums, p));
    }
}
