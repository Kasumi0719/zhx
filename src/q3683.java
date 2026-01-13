import java.util.Arrays;
import java.util.Comparator;

public class q3683 {
    public static int earliestTime(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] + o1[0]- o2[1] - o2[0];
            }
        });
        return tasks[0][0] + tasks[0][1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 6}, {2, 3}};
        System.out.println(earliestTime(input));
    }
}
