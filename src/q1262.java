import java.util.Arrays;

public class q1262 {
    public static int maxSumDivThree(int[] nums) {
        int[][] record = new int[3][nums.length + 1];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(record[i], -1);
        }
        for(int i = 0; i < nums.length; i++){
            int release = nums[i] % 3;
            for(int j = 0; j < 3; j++){
                record[j][i + 1] = Math.max(record[j][i], record[j][i + 1]);
                if(record[j][i] == -1){
                    record[release][i + 1] = Math.max(record[release][i + 1], nums[i]);
                } else {
                    record[(release + j) % 3][i + 1] = Math.max(record[(release + j) % 3][i + 1], record[j][i] + nums[i]);
                }
            }
        }
        return record[0][nums.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }
}
