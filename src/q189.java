public class q189 {
    public void rotate(int[] nums, int k) {
        int real_k = k % nums.length;
        int[] record = new int[real_k];
        for(int i = nums.length - real_k; i < nums.length; i++) {
            record[i - nums.length + real_k] = nums[i];
        }
        for(int i = nums.length - 1; i >= real_k; i--) {
            nums[i] = nums[i - real_k];
        }
        for(int i = 0; i < real_k; i++) {
            nums[i] = record[i];
        }
    }
}
