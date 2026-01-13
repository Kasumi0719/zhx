public class q712 {
    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 1; i <= s2.length(); i++) dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        for(int i = 1; i <= s1.length(); i++) dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);

        for(int i = 1; i <= s2.length(); i++) {
            for(int j = 1; j <= s1.length(); j++) {
                if(s1.charAt(j - 1) == s2.charAt(i - 1)) {
                    dp[j][i] = Math.min(dp[j - 1][i - 1], Math.min(dp[j - 1][i] + s1.charAt(j - 1), dp[j][i - 1] + s2.charAt(i - 1)));
                } else {
                    dp[j][i] = Math.min(dp[j - 1][i - 1] + s2.charAt(i - 1) + s1.charAt(j - 1), Math.min(dp[j - 1][i] + s1.charAt(j - 1), dp[j][i - 1] + s2.charAt(i - 1)));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minimumDeleteSum(s1, s2));
    }
}
