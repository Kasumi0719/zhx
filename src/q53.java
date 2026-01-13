public class q53 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int maxNow = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0){
                if(maxNow <= 0){
                    maxNow = num;
                    result = Math.max(maxNow, num);
                }else{
                    maxNow = num + maxNow;
                    result = Math.max(maxNow, num);
                }
            }else{
                if(maxNow <= 0){
                    maxNow = num;
                    result = Math.max(maxNow, num);
                }else {
                    maxNow = num + maxNow;
                    result = Math.max(maxNow, num);
                }
            }
        }
        return result;
    }
}
