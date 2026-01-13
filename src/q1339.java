public class q1339 {
    long res = 0;

    public int maxProduct(TreeNode root) {
        int MOD = 1_000_000_007;
        // 记录总和
        int sum = getSum(root);
        maxTree(root, sum);
        res %= MOD;
        return (int) res;
    }

    public int getSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        return root.val + left + right;
    }

    public void maxTree(TreeNode root, int sum) {
        if(root.left == null && root.right == null) {
            long cur = (long) root.val * (sum - root.val);
            res = Math.max(res, cur);
        }
        if(root.left != null) {
            maxTree(root.left, sum);
            long cur = (long) root.left.val * (sum - root.left.val);
            res = Math.max(res, cur);
            root.val += root.left.val;
        }
        if(root.right != null) {
            maxTree(root.right, sum);
            long cur = (long) root.right.val * (sum - root.right.val);
            res = Math.max(res, cur);
            root.val += root.right.val;
        }
    }
}
