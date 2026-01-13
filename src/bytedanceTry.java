import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bytedanceTry {
    List<Integer> result = new ArrayList<>();
    List<Integer> result2;
    public int findN(int n, int[] nums) {
        List<Integer> record = new ArrayList<>();
        Arrays.sort(nums);
        while(n > 0){
            record.add(n % 10);
            n /= 10;
        }
        reverse(record, record.size() - 1, nums);
        int mayBe = 0;
        int realResult = 0;
        int tenNum = 1;
        int tenNum2 = 1;
        for(int i = 0; i < record.size() - 1; i++){
            mayBe += nums[nums.length - 1] * tenNum;
            tenNum *= 10;
        }
        if(result2 == null) return mayBe;
        for(int i = result2.size() - 1; i >= 0; i--){
            realResult += result2.get(i) * tenNum2;
            tenNum2 *= 10;
        }
        return Math.max(mayBe, realResult);
    }
    public void reverse(List<Integer> record, int index, int[] nums) {
        if(index == -1 && result2 == null) {
            result2 = List.copyOf(result);
            return;
        }
        if(record.get(index) < nums[0]) return;
        for(int i = nums.length - 1; i >= 0; i--){
            if(record.get(index) < nums[i]) continue;
            if(record.get(index) > nums[i]){
                result.add(nums[i]);
                while(result.size() < record.size()) result.add(nums[nums.length - 1]);
                result2 = List.copyOf(result);
                return ;
            }
            result.add(nums[i]);
            reverse(record, index - 1, nums);
            result.remove(result.size() - 1);
        }
        return;
    }
}
