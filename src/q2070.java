import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class q2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int maxNow = items[0][1];
        for(int i = 1; i < items.length; i++) {
            maxNow = Math.max(maxNow, items[i][1]);
            items[i][1] = maxNow;
        }

        for(int i = 0; i < queries.length; i++) {
            queries[i] = query(items, queries[i]);
        }
        return queries;
    }

    public int query(int[][] items, int target) {
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (items[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(right < 0) return 0;
        else return items[right][1];
    }
}
