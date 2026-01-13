import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> record = new LinkedList<>();
        record.add(root);
        while (!record.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = record.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = record.poll();
                list.add(node.val);
                if (node.left != null) {
                    record.add(node.left);
                }
                if (node.right != null) {
                    record.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
