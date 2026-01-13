import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class TestQ2 {
    static List<List<Integer>> adj;
    static int[] heights;
    static int[] dp; // dp[i] 存储从景点 i 开始的最长递减路径的长度

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 景点数量
        int m = sc.nextInt(); // 路线数量

        heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1; // 转换为0-indexed
            int v = sc.nextInt() - 1; // 转换为0-indexed

            if (heights[u] > heights[v]) {
                adj.get(u).add(v);
            } else if (heights[v] > heights[u]) {
                adj.get(v).add(u);
            }
            // 如果 heights[u] == heights[v]，则不能向下走，不添加边
        }

        sc.close();

        dp = new int[n];
        Arrays.fill(dp, -1); // 初始化dp数组为-1，表示未计算

        int maxTotalLength = 0;
        for (int i = 0; i < n; i++) {
            maxTotalLength = Math.max(maxTotalLength, dfs(i));
        }

        System.out.println(maxTotalLength);
    }

    // DFS函数，计算从景点 u 开始的最长递减路径的长度
    static int dfs(int u) {
        if (dp[u] != -1) {
            return dp[u]; // 如果已计算过，直接返回
        }

        int maxLength = 1; // 至少包含景点 u 自己
        for (int v : adj.get(u)) {
            maxLength = Math.max(maxLength, 1 + dfs(v));
        }

        dp[u] = maxLength; // 存储计算结果
        return maxLength;
    }
}