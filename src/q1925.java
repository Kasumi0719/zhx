public class q1925 {
    public int countTriples(int n) {
        int res = 0;
        for(int left = 1; left < n - 1; left++ ) {
            for(int right = left + 1; right < n; right++ ) {
                for(int last = right + 1; last < n + 1; last++) {
                    if(left * left + right * right == last * last) {
                        res += 2; break;
                    } else if(left * left + right * right < last * last){
                        break;
                    }
                }
            }
        }
        return res;
    }
}
