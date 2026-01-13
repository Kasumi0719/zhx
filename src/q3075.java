import java.util.Arrays;

public class q3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        int len = happiness.length;
        Arrays.sort(happiness);
        int curMinus = 0;
        for (int i = len - 1; i >= len - k; i--) {
            if (happiness[i] >= curMinus) {
                res += happiness[i];
            } else {
                break;
            }
        }
        return res;
    }
}
