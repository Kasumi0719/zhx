import java.util.Arrays;
import java.util.Comparator;

public class q3025 {
    public static int numberOfPairs(int[][] points) {
        int res = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) {
                    return p2[1] - p1[1];
                }
                return p1[0] - p2[0];
            }
        });
        for (int i = 0; i < points.length - 1; i++) {
            int curY = 0;
            int j = i + 1;
            for (; j < points.length; j++) {
                if(points[j][1] <= points[i][1]){
                    curY = points[j][1];
                    res++;
                    break;
                }
            }
            j++;
            for(; j < points.length; j++) {
                if(points[j][1] <= points[i][1] && points[j][1] > curY){
                    res++;
                    curY = points[j][1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 6}, {0, 9}, {0, 3}};
        System.out.println(q3025.numberOfPairs(points));
    }
}
