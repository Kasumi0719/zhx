import java.util.ArrayList;
import java.util.List;

public class q78 {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> record = new ArrayList<>();
        result.add(record);
        for(int i = 0 ; i < nums.length ; i++){
            record.add(nums[i]);
            reverse(record, nums, i);
            record.remove(record.size() - 1);
        }
        return result;
    }

    public void reverse(List<Integer> record, int[] nums, int index){
        result.add(new ArrayList<>(record));
        for(int i = index + 1; i < nums.length; i++){
            record.add(nums[index]);
            reverse(record, nums, i);
            record.remove(record.size() - 1);
        }
    }
}
