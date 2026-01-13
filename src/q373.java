import java.util.*;

public class q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> record = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1);
            }
        });

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(record.size() < k) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]); list.add(nums2[j]);
                    record.add(list);
                }else if(record.size() == k && (record.peek().get(0) + record.peek().get(1)) < nums1[i] + nums2[j]) {
                    record.poll();
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]); list.add(nums2[j]);
                    record.add(list);
                }
            }
        }
        return new ArrayList<>(record);
    }
}
