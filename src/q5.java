public class q5 {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) dp[i][i] = 1;
        int result = 0;
        int left = 0;
        int right = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if(result < dp[i][j]){
                        result = dp[i][j];
                        left = i; right = j;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
