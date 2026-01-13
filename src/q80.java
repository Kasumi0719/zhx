public class q80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int left = -1;
        int right = 0;
        while(right < nums.length - 1){
            if(nums[right + 1] == nums[right]){
                nums[++left] = nums[right];
                nums[++left] = nums[++right];
                while(right < nums.length - 1 && nums[right + 1] == nums[right]){
                    right++;
                }
                right++;
            } else {
                nums[++left] = nums[right];
                right++;
            }
        }
        if(nums[right] != nums[right - 1]) nums[++left] = nums[right];
        return left + 1;
    }
}
