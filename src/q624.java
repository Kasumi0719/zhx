import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class q624 {
    public int maxDistance(List<List<Integer>> arrays) {
        PriorityQueue<int[]> maxNum = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minNum = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            if(maxNum.size() < 2 || list.get(list.size() - 1) > maxNum.peek()[0]) {
                maxNum.offer(new int[]{list.get(list.size() - 1), i});
                if(maxNum.size() > 2) maxNum.poll();
            }
            if(minNum.size() < 2 || list.get(0) < minNum.peek()[0]) {
                minNum.offer(new int[]{list.get(0), i});
                if(minNum.size() > 2) minNum.poll();
            }
        }
        int[] max = maxNum.poll();
        int[] min = minNum.poll();
        if(maxNum.peek()[1] != minNum.peek()[1]) return maxNum.peek()[0] - minNum.peek()[0];
        return Math.max(max[0] - minNum.peek()[0], maxNum.peek()[0] - min[0]);
    }
}
