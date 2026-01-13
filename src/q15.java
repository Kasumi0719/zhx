import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;

        Arrays.sort(nums);
        int left = 0;
        while(left < nums.length - 2 && nums[left] < 0) {
            if(left > 0 && nums[left] == nums[left - 1]){
                left++; continue;
            }
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                if(nums[mid] + nums[right] + nums[left] < 0){
                    mid++;
                }else if(nums[mid] + nums[right] + nums[left] > 0){
                    right--;
                }else{
                    List<Integer> list = Arrays.asList(nums[left], nums[mid], nums[right]);
                    result.add(list);
                    while(++mid < right && nums[mid] == nums[mid - 1]) continue;
                    while(--right > left && nums[right] == nums[right + 1]) continue;
                }
            }
            left++;
        }
        return result;
    }
}
