import java.util.ArrayList;
import java.util.List;

public class q2147 {
    public static int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        long res = 1;
        int curSeat = 0;
        int validSeat = 0;
        int lastIndex = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if(corridor.charAt(i) == 'S') {
                if(curSeat != 0 && validSeat == curSeat) res = (res * (i - lastIndex)) % MOD;
                curSeat++;
                if(curSeat != 0 && curSeat % 2 == 0){
                    lastIndex = i;
                    validSeat = curSeat;
                }
            }
        }
        return (curSeat % 2 == 0 && curSeat > 0) ? (int) res : 0;
    }

    public static void main(String[] args) {
        String corridor = "PPSPSP";
        System.out.println(numberOfWays(corridor));
    }
}
