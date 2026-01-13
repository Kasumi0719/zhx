import java.util.Arrays;
import java.util.Comparator;

public class q452 {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < points.length - 1; i++) {
            if (points[i + 1][0] < points[i][1]) {
                if(i == points.length - 2){
                    result++; break;
                }
                points[i + 1][0] = Math.max(points[i][0], points[i + 1][0]);
                points[i + 1][1] = Math.min(points[i][1], points[i + 1][1]);
            }else{
                result++;
            }
        }
        return result;
    }
}
