public class q153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[left] < nums[right]){
                right = mid - 1;
            }else{
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            result = nums[mid] < nums[result] ? mid : result;
        }
        return nums[result];
    }
}
