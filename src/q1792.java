import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for(int i = 0; i < classes.length; i++){
            if(classes[i][0] == classes[i][1]) continue;
            pq.offer(new int[]{classes[i][1], i});
        }
        while(!pq.isEmpty() && extraStudents > 0){
            int[] cur = pq.peek();
            if(classes[cur[1]][1] - classes[cur[1]][0] <= extraStudents){
                extraStudents = extraStudents - (classes[cur[1]][1] - classes[cur[1]][0]);
                classes[cur[1]][0] = classes[cur[1]][1];
                pq.poll();
            } else {
                extraStudents = 0;
                classes[cur[1]][0] += extraStudents;
            }
        }
        double res = 0;
        for(int i = 0; i < classes.length; i++){
            res += (double) classes[i][0] / classes[i][1];
        }
        return res / classes.length;
    }

    public static void main(String[] args) {
        q1792 model = new q1792();
        Map<String, String> rec = new HashMap<>();
        int[][] input = new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        System.out.println(model.maxAverageRatio(input, 4));
    }
}
