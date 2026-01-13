import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q1161 {
    public int maxLevelSum(TreeNode root) {
        int res = 1;
        int max_sum = root.val;
        int cur_sum = 0;
        int height = 1;
        Queue<TreeNode> record = new LinkedList<>();

        int size = 1;
        record.add(root);

        while(!record.isEmpty()) {
            TreeNode node = record.poll();
            if (node.left != null) {
                record.add(node.left);
            }
            if (node.right != null) {
                record.add(node.right);
            }
            cur_sum += node.val;
            size -= 1;
            if(size == 0){
                if(cur_sum > max_sum){
                    res = height;
                    max_sum = cur_sum;
                }
                cur_sum = 0;
                height++;
                size = record.size();
            }
        }
        return res;
    }
}
