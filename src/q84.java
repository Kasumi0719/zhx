import java.util.Deque;
import java.util.LinkedList;

public class q84 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int[] leftLen = new int[heights.length];
        int[] rightLen = new int[heights.length];
        Deque<Integer> recordRight = new LinkedList<>();
        for(int i = 0; i < heights.length; i++) {
            rightLen[i] = heights.length - 1 - i;
            while(!recordRight.isEmpty() && heights[recordRight.peekLast()] > heights[i]) {
                rightLen[recordRight.peekLast()] = i - recordRight.peekLast() - 1;
                recordRight.pollLast();
            }
            recordRight.addLast(i);
        }
        Deque<Integer> recordLeft = new LinkedList<>();
        for(int i = heights.length - 1; i >= 0; i--) {
            leftLen[i] = i;
            while(!recordLeft.isEmpty() && heights[recordLeft.peekLast()] > heights[i]) {
                leftLen[recordLeft.peekLast()] = recordLeft.peekLast() - i - 1;
                recordLeft.pollLast();
            }
            recordLeft.addLast(i);
        }
        for(int i = 0; i < heights.length; i++) {
            result = Math.max(result, (leftLen[i] + rightLen[i] + 1) * heights[i]);
        }
        return result;
    }
}
