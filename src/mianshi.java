import java.util.*;

class mianshi {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node1 = new TreeNode(1, node2, node3);
        List<Integer> result = rightSideView(node1);
        for(int res : result) System.out.println(res);
    }

    public static List<Integer> rightSideView(TreeNode node){
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> record = new LinkedList<>();
        record.addLast(node);
        while(!record.isEmpty()){
            int len = record.size();
            for(int i = 0; i < len; i++){
                TreeNode cur = record.getFirst();
                if(i == len - 1) result.add(cur.val);
                if(cur.left != null) record.addLast(cur.left);
                if(cur.right != null) record.addLast(cur.right);
            }
        }
        return result;
    }



}