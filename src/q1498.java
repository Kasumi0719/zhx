import java.util.Arrays;

public class q1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        int mod = (int) 1e9 + 7;
        while(left <= right) {
            while(nums[right] > target - nums[left] && right >= left) right--;
            if(right < left) break;
            int cur = (int) Math.pow(2, right - left);
            cur %= mod;
            result = (result + cur) % ((int)1e9 + 7);
            left++;
        }
        return result;
    }
}
