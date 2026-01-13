import java.util.HashSet;
import java.util.Set;

public class q36 {
    public boolean isValidSudoku(char[][] board) {
        Set[] record = new Set[27];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                //非数字跳过
                if(board[i][j] == '.') continue;
                // 判断一行
                if(record[j] == null) record[j] = new HashSet<Character>();
                if(record[j].contains(board[i][j])) return false;
                record[j].add(board[i][j]);
                // 判断一列
                if(record[9 + i] == null) record[9 + i] = new HashSet<Character>();
                if(record[9 + i].contains(board[i][j])) return false;
                record[9 + i].add(board[i][j]);
                // 判断3*3格子
                if(record[18 + 3 * (i / 3) + j / 3] == null) record[18 + 3 * (i / 3) + j / 3] = new HashSet<Character>();
                if(record[18 + 3 * (i / 3) + j / 3].contains(board[i][j])) return false;
                record[18 + 3 * (i / 3) + j / 3].add(board[i][j]);
            }
        }
        return true;
    }
}