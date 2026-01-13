import java.util.HashSet;
import java.util.Set;

public class q1015 {
    public static int smallestRepunitDivByK(int k) {
        int release = 1;
        int res = 1;
        Set<Integer> record = new HashSet<>();
        while(!record.contains(release)) {
            if(release % k == 0) return res;
            record.add(release);
            release = (release % k) * 10 + 1;
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(3));
    }
}
