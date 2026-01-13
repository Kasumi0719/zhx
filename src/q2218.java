import java.util.List;

public class q2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        for (List<Integer> pile : piles) {
            for (int i = 1; i < pile.size(); i++){
                int middle = pile.get(i);
                pile.set(i, middle + pile.get(i - 1));
            }
        }
        for (int i = 1; i <= piles.size(); i++){
            for (int j = 1; j <= k; j++){
                int value = dp[i - 1][j];
                int bound = Math.min(piles.get(i - 1).size(), j);
                for (int l = 0; l < bound; l++){
                    value = Math.max(value, piles.get(i - 1).get(l) + dp[i - 1][j - l - 1]);
                }
                dp[i][j] = value;
            }
        }
        return dp[piles.size() - 1][k];
    }
}
