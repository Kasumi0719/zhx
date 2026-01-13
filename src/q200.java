public class q200 {
    int result = 0;
    boolean[][] isVisited;
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' && !isVisited[i][j]){
                    reverse(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void reverse(char[][] grid, int row, int col) {
        isVisited[row][col] = true;
        for (int i = 0; i < 4; i++){
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];
            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length &&
                    grid[nextRow][nextCol] == '1' && !isVisited[nextRow][nextCol]) reverse(grid, nextRow, nextCol);
        }
        return ;
    }
}
