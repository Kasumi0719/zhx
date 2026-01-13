import java.util.LinkedList;
import java.util.Queue;

public class q130 {
    int[][] used;
    int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        used = new int[row][col];
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O' && used[i][0] == 0) passThrough(board, i, 0);
        }
        for(int i = 0; i < row; i++){
            if(board[i][col - 1] == 'O' && used[i][col - 1] == 0) passThrough(board, i, col - 1);
        }
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O' && used[0][i] == 0) passThrough(board, 0, i);
        }
        for(int i = 0; i < col; i++){
            if(board[row - 1][i] == 'O' && used[row - 1][i] == 0) passThrough(board, row - 1, i);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O' && used[i][j] == 0) board[i][j] = 'X';
            }
        }
    }

    public void passThrough(char[][] board, int x, int y){
        Queue<int[]> record = new LinkedList<>();
        used[x][y] = 1;
        record.add(new int[]{x, y});
        while(!record.isEmpty()){
            int[] pos = record.poll();
            for(int k = 0; k < direction.length; k++){
                int nextX = pos[0] + direction[k][0];
                int nextY = pos[1] + direction[k][1];
                if(nextX >= 0 && nextX <= board.length && nextY >= 0 && nextY <= board[0].length && used[nextX][nextY] != 1){
                    used[nextX][nextY] = 1;
                    record.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
