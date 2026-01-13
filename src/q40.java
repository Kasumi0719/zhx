import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q40 {
    int[] used;

    List<Integer> path;

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length; i++) {
            reverse(candidates, target, i, 0);
        }
        return result;
    }

    public void reverse(int[] candidates, int target, int index, int sum){
        if (index != 0 && candidates[index - 1] == candidates[index] && used[index - 1] == 0) return;
        if (sum == target){
            result.add(new ArrayList<>(path)); return;
        }
        for(int i = index + 1; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            used[i] = 1;
            path.add(candidates[i]);
            reverse(candidates, target, i, sum + candidates[i]);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
        return ;
    }
}
