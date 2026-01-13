public class q35 {
    public int[] left;

    public int[] right;

    public int candy(int[] ratings) {
        left = new int[ratings.length];
        right = new int[ratings.length];
        getLeftMax(ratings);
        getRightMax(ratings);
        int sum = 0;
        for(int i = 0; i < ratings.length; i++){
            sum += Math.max(left[i], right[i]) + 1;
        }
        return sum;
    }

    public void getRightMax(int[] ratings){
        int start = 0;
        int back = 0;
        while(start <= ratings.length - 1){
            if(start == ratings.length - 1 || ratings[start + 1] >= ratings[start]){
                while(back > 0){
                    right[start - back] = back;
                    back--;
                }
            }else{
                back += 1;
            }
            start++;
        }
    }

    public void getLeftMax(int[] ratings){
        int start = ratings.length - 1;
        int back = 0;
        while(start >= 0){
            if(start == 0 || ratings[start - 1] >= ratings[start]){
                while(back > 0){
                    left[start + back] = back;
                    back--;
                }
            }else{
                back += 1;
            }
            start--;
        }
    }
}
