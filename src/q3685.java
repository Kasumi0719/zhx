import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class q3685 {
    public static boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        boolean[] res = new boolean[nums.length];
        Arrays.sort(nums);
        for(int max = nums.length; max > 0; max--) {
            for(int last = nums.length - 1; last >= 2; last--) {
                if(last < nums.length - 1 && nums[last] >= max) continue;
                int lastNum = Math.min(nums[last], max);
                int left = 0;
                int right = last - 1;
                while(left < right) {
                    int leftNum = Math.min(nums[left], max);
                    int rightNum = Math.max(nums[right], max);
                    if(leftNum + rightNum + lastNum== k) {
                        res[max - 1] = true;
                        break;
                    } else if (leftNum + rightNum + lastNum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(subsequenceSumAfterCapping(nums, 3)));
    }
}
