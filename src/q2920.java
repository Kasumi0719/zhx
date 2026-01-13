import sun.misc.Unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q2920 {
    public class TreeNode {
        int release;
        int index;
        TreeNode left;
        TreeNode right;
        TreeNode(int index) {
            this.index = index;
        }
    }

    Map<Integer, TreeNode> record = new HashMap<>();

    public void maximumPoints(int[][] edges, int[] coins, int k) {
        initiate(edges, coins);

    }

    public void initiate(int[][] edges, int[] coins){
        for (int[] edge : edges){
            TreeNode father = record.getOrDefault(edge[0], new TreeNode(edge[0]));
            TreeNode children = record.getOrDefault(edge[1], new TreeNode(edge[1]));
            if(father.left == null){
                father.left = children;
            }else{
                father.right = children;
            }
            record.put(edge[0], father);
            record.put(edge[1], children);
        }
        TreeNode root = record.get(0);

        reverse(root, coins);
    }

    public int reverse(TreeNode root, int[] coins) {
        if (root == null) return 0;
        int leftSum = reverse(root.left, coins);
        int rightSum = reverse(root.right, coins);
        root.release = leftSum + rightSum + coins[root.index];
        return root.release;
    }
}
