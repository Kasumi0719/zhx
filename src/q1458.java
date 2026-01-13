public class q1458 {
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0] * nums2[0];
        for (int i = 1; i < nums2.length; i++) dp[0][i] = Math.max(dp[0][i - 1], nums2[i] * nums1[0]);
        for (int i = 1; i < nums1.length; i++) dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);

        for(int i = 1; i < nums1.length; i++){
           for(int j = 1; j < nums2.length; j++){
               dp[i][j] = Math.max(Math.max(nums1[i] * nums2[j], dp[i - 1][j - 1] + Math.max(0, nums1[i] * nums2[j])), Math.max(dp[i - 1][j], dp[i][j - 1]));
           }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {-3,-8,3,-10,1,3,9};
        int[] nums2 = {9,2,3,7,-9,1,-8,5,-1,-1};
        System.out.println(q1458.maxDotProduct(nums1, nums2));
    }
}
