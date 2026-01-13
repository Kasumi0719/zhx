import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] <= intervals[i][1]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            }else{
                resultList.add(intervals[i]);
            }
        }
        resultList.add(intervals[intervals.length - 1]);
        return resultList.toArray(new int[resultList.size()][]);
    }
}
