import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2561 {
    public long minCost(int[] basket1, int[] basket2) {
        long res = 0;
        Map<Integer, Integer> record = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < basket1.length; i++) {
            record.put(basket1[i], record.getOrDefault(basket1[i], 0) + 1);
            record.put(basket2[i], record.getOrDefault(basket2[i], 0) - 1);
            min = Math.min(min, basket1[i]);
            min = Math.min(min, basket2[i]);
        }
        List<int[]> allPair = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            if (entry.getValue() == 0) continue;
            if(Math.abs(entry.getValue()) % 2 != 0) return -1;
            if(entry.getValue() > 0) {
                allPair.add(new int[]{entry.getKey(), Math.abs(entry.getValue() / 2), 0});
            } else {
                allPair.add(new int[]{entry.getKey(), 0, Math.abs(entry.getValue() / 2)});
            }
        }
        allPair.sort((o1, o2) -> o1[0] - o2[0]);
        int left = 0;
        int right = allPair.size() - 1;
        while (left < allPair.size() && right >= 0) {
            while(left < allPair.size() && allPair.get(left)[1] == 0) left++;
            while(right >= 0 && allPair.get(right)[2] == 0) right--;
            if(left >= allPair.size() || right < 0) break;
            res += (long) Math.min(allPair.get(left)[1], allPair.get(right)[2]) * Math.min(Math.min(allPair.get(right)[0], allPair.get(left)[0]), 2 * min);
            int del = allPair.get(left)[1] - allPair.get(right)[2];
            allPair.get(left)[1] = Math.max(del, 0);
            allPair.get(right)[2] = Math.max(-del, 0);
        }
        return res;
    }
}
