import java.util.*;

public class qmianshi {
    public int smallestDifference(int[] a, int[] b) {
        int res = Integer.MAX_VALUE;
        List<int[]> record = new ArrayList<>();
        for(int numA : a) record.add(new int[]{numA, 1});
        for(int numB : b) record.add(new int[]{numB, 2});
        record.sort((o1, o2) -> o1[0] - o2[0]);
        for(int i = 1; i < record.size(); i++) {
            if(record.get(i)[1] != record.get(i - 1)[1]) res = Math.min(res, record.get(i)[0] - record.get(i - 1)[0]);
        }
        return res;
    }
}
