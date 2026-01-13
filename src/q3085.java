import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q3085 {
    int[] freq;
    int[] freqSum;
    Map<Character, Integer> record = new HashMap<>();

    public int minimumDeletions(String word, int k) {
        for(int i = 0; i < word.length(); i++) {
            record.put(word.charAt(i), record.getOrDefault(word.charAt(i), 0) + 1);
        }
        int index = 0;
        freq = new int[record.size()];
        freqSum = new int[record.size() + 1];
        for (Map.Entry<Character, Integer> entry : record.entrySet()) {
            freq[index++] = entry.getValue();
        }
        Arrays.sort(freq);
        if(freq[freq.length - 1] - freq[0] <= k) return 0;
        for (int i = 1; i <= freq.length; i++) {
            freqSum[i] = freqSum[i - 1] + freq[i - 1];
        }
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(right < freq.length){
            if(freq[right] - freq[left] <= k){
                right++; continue;
            }
            result = Math.min(result, freqSum[left] - (freq.length - right) * (freq[left] + k) + freqSum[freq.length] - freqSum[right]);
            left++;
        }
        return Math.min(result, freqSum[left]);
    }
}
