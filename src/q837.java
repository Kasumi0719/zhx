public class q837 {
    public double new21Game(int n, int k, int maxPts) {
        double res = 0;
        double[][] dp = new double[n][k + 1];
        for(int i = 0; i < n; i++) dp[i][0] = 1;
        for(int j = 1; j < k + 1; j++){
            for(int i = 1; i < n; i++){
                dp[i][j] = (double) (i - Math.max(0, i - maxPts)) / maxPts;
            }
        }
        for(int i = 0; i < n; i++) res += dp[i][k];
        return res;
    }
}
