import java.util.PriorityQueue;

public class q2209 {
    PriorityQueue<int[]> record = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    int blackCount = 0;
    int[] floorArr;
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        passThrough(floor, carpetLen);
        while(numCarpets > 0 && !record.isEmpty()) {
            int[] arr = record.poll();
            if(floorArr[arr[0]] != 1) {
                for(int j = arr[0]; j < arr[0] + carpetLen && j < floorArr.length; j++) floorArr[j] = 1;
                blackCount += arr[0];
                numCarpets--;
            }
        }
        return floor.length() - blackCount;
    }
    public void passThrough(String floor, int carpetLen) {
        int left = 0;
        int right = 0;
        int whiteCount = 0;
        floorArr = new int[floor.length()];
        while(right < floor.length() && right < carpetLen) {
            if(floor.charAt(right) == '0'){
                blackCount++;
                floorArr[right] = 1;
            }
            if(floor.charAt(right) == '1') whiteCount++;
            right++;
        }
        record.add(new int[]{whiteCount, left});
        while(right < floor.length()) {
            if(floor.charAt(right) == '0'){
                blackCount++;
                floorArr[right] = 1;
            }
            if(floor.charAt(left++) == '1') whiteCount--;
            if(floor.charAt(right++) == '1') whiteCount++;
            record.add(new int[]{whiteCount, left});
        }
    }
}
