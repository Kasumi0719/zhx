import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//5 3
//        0 1 1 2 2
//AUGBC
//4 3
//4 5
//        4 1
class XiaoMeiYouGenShu {
    static class TreeNode{
        char data;
        TreeNode fatherNode;
        int index;
        TreeNode(char data, TreeNode fatherNode, int index){
            this.index = index;
            this.data = data;
            this.fatherNode = fatherNode;
        }
    }

    static Map<Integer, TreeNode> record = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = scanner.nextInt();
        }
        // 读取第三行输入
        String line = scanner.next();
        // 假设这是由大写字母组成的字符串
        char[] chars = line.toCharArray();
        create(father, chars);

        // 创建一个二维数组来存储查询
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < q; i++) {
            if(haveBug(queries[i])) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    public static void create(int[] father, char[] chars) {
        TreeNode root = new TreeNode(chars[0], null, 1);
        record.put(1, root);
        for(int i = 1; i < chars.length; i++) {
            TreeNode child = new TreeNode(chars[i], record.get(father[i]), i + 1);
            record.put(i + 1, child);
        }
    }
    public static boolean haveBug(int[] indexPair) {
        TreeNode nodeL = record.get(indexPair[0]);
        TreeNode nodeR = record.get(indexPair[1]);
        StringBuilder passStrL = new StringBuilder();
        StringBuilder passStrR = new StringBuilder();
        while (nodeL.index != nodeR.index) {
            if(nodeL.index > nodeR.index) {
                passStrL.append(nodeL.data);
                nodeL = nodeL.fatherNode;
            } else {
                passStrR.append(nodeR.data);
                nodeR = nodeR.fatherNode;
            }
        }
        passStrL.append(nodeL.data);
        String passStrAll = passStrL.toString() + passStrR.reverse().toString();
        return isSubsequence(passStrAll, "BUG");
    }
    public static boolean isSubsequence(String s, String sub) {
        int i = 0, j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}
