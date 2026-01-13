import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XiaoMeiJiaPao {
    public void getNum(int[][] position, int num){
        Map<Integer, List<Integer>> posX = new HashMap<>();
        Map<Integer, List<Integer>> posY = new HashMap<>();
        for(int[] pos : position){
            List<Integer> rowX = posX.getOrDefault(pos[0], new ArrayList<>());
            rowX.add(pos[1]);
            posX.put(pos[0], rowX);
            List<Integer> rowY = posX.getOrDefault(pos[0], new ArrayList<>());
            rowY.add(pos[0]);
            posX.put(pos[1], rowY);
        }
        for(int[] pos : position){
            int result = 0;
            int thisX = query(posX.get(pos[0]), pos[1]);
            int thisY = query(posY.get(pos[1]), pos[0]);
            if(thisX > 1) result += 1;
            if(thisY > 1) result += 1;
            if(thisX < posX.get(pos[0]).size() - 2) result += 1;
            if(thisY < posY.get(pos[1]).size() - 2) result += 1;
        }
    }

    public int query(List<Integer> row, int num){
        int left = 0;
        int right = row.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(row.get(mid) == num){
                return mid;
            }else if(row.get(mid) > num){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
