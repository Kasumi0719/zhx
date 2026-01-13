import java.util.*;

public class q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<int[]> record = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while (!record.isEmpty() && record.peekLast()[0] < nums[i]) {
                record.removeLast();
            }
            record.addLast(new int[]{nums[i], i});
        }
        result[0] = record.peekFirst()[0];

        for (int i = k; i < nums.length; i++) {
            if(record.peekFirst()[1] < i - k + 1) record.removeFirst();
            while (!record.isEmpty() && record.peekLast()[0] < nums[i]) {
                record.removeLast();
            }
            record.addLast(new int[]{nums[i], i});
            result[i - k  + 1] = record.peekFirst()[0];
        }
        return result;
    }
}
