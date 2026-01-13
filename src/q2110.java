public class q2110 {
    public long getDescentPeriods(int[] prices) {
        long res = 1;
        int continueLen = 1;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] == prices[i - 1] - 1){
                continueLen++;
            } else {
                if(continueLen > 1) {
                    res += (long) (continueLen + 1) * continueLen / 2;
                    continueLen = 1;
                } else {
                    res += 1;
                }
            }
        }
        if(continueLen > 1) {
            res += (long) (continueLen + 1) * continueLen / 2;
        } else {
            res += 1;
        }
        return res;
    }
}
