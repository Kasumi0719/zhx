import java.util.Arrays;

public class q3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        int res = 0;
        for(int app : apple) {
            sum += app;
        }
        Arrays.sort(capacity);
        for(int i = capacity.length - 1; i >= 0; i--) {
            if(sum <= 0) return res;
            sum -= capacity[i];
            res++;
        }
        return res;
    }
}
