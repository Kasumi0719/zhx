import java.util.Arrays;
import java.util.Collections;

public class q33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if(target < nums[0] && target > nums[nums.length - 1]) return -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return target;
            if((nums[mid] < target && nums[right] >= target) || (nums[mid] > target && nums[right] >= target)){
                left = mid + 1;
                continue;
            }
            if((nums[mid] > target && nums[left] <= target) || (nums[mid] < target && nums[left] <= target)){
                right = mid - 1;
                continue;
            }
        }
        return -1;
    }
}
