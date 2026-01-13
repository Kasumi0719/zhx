import java.util.ArrayList;
import java.util.List;

public class q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int step = 0;
        while(result.size() < col * row){
            if(step % 4 == 0){
                for(int i = step / 4; i <= col - step / 4 - 1; i++){
                    result.add(matrix[step / 4][i]);
                }
                step += 1;
            } else if (step % 4 == 1) {
                for(int i = step / 4 + 1; i <= row - step / 4 - 2; i++){
                    result.add(matrix[i][col - step / 4 - 1]);
                }
                step += 1;
            } else if (step % 4 == 2) {
                for(int i = col - step / 4 - 1; i >= step / 4; i--){
                    result.add(matrix[row - step / 4 - 1][i]);
                }
                step += 1;
            } else if (step % 4 == 3) {
                for(int i = row - step / 4 - 2; i >= step / 4 + 1; i--){
                    result.add(matrix[i][step / 4]);
                }
                step += 1;
            }
        }
        return result;
    }
}
