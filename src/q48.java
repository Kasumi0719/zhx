import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class q48 {
    public void rotate(int[][] matrix) {
        int floorMax = matrix.length / 2;
        int floor = 0;
        for (; floor < floorMax; floor++) {
            for (int j = floor; j < matrix.length - floor - 1; j++){
                int temp = matrix[floor][j];
                matrix[floor][j] = matrix[matrix.length - j - 1][floor];
                matrix[matrix.length - j - 1][floor] = matrix[matrix.length - floor - 1][matrix[0].length - j - 1];
                matrix[matrix.length - floor - 1][matrix[0].length - j - 1] = matrix[j][matrix[0].length - floor - 1];
                matrix[j][matrix[0].length - floor - 1] = temp;
                Map<String, String> prac = new HashMap<>();
                ArrayList<Integer> arr = new ArrayList<>();
            }
        }

    }
}
