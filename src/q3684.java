import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q3684 {
    public int[] maxKDistinct(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0 && list.size() < k; i--) {
            if(i == nums.length - 1 || nums[i] != nums[i + 1]) {
                list.add(nums[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
