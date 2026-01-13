public class q3381 {
    public static long maxSubarraySum(int[] nums, int k) {
        long res = Long.MIN_VALUE;
        long[] record = new long[nums.length - k + 1];
        long[] passed = new long[nums.length + 1];
        for(int i = 1; i < passed.length; i++){
            passed[i] = passed[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < record.length; i++) {
            record[i] = passed[i + k] - passed[i];
            if(i >= k && record[i - k] > 0) record[i] += record[i - k];
            res = Math.max(res, record[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-5,1,2,-3,4};
        int k = 2;
        System.out.println(maxSubarraySum(nums, k));
    }
}
