import java.util.HashSet;
import java.util.Set;

public class q128 {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> hasVisit = new HashSet<>();
        Set<Integer> allValue = new HashSet<>();
        for (int num : nums) {
            allValue.add(num);
        }
        for(int num : nums){
            if(hasVisit.contains(num)) continue;
            if(allValue.contains(num + 1)){
                hasVisit.add(num);
                continue;
            }
            int count = 0;
            while(allValue.contains(num)){
                hasVisit.add(num);
                count++;
                num = num - 1;
            }
            result  = Math.max(result, count);
        }
        return result;
    }
}
