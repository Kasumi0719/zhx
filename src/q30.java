import java.util.*;

public class q30 {
    public int oneWordLen;

    public Set<String> record = new HashSet<>();

    public List<Integer> findSubstring(String s, String[] words) {
        int[] used = new int[words.length];
        List<Integer> res = new ArrayList<>();
        oneWordLen = words.length * words[0].length();
        for (int i = 0; i < words.length; i++) {
            used[i] = 1;
            reverse(words, i, used, "");
            used[i] = 0;
        }
        for(int i = 0; i + oneWordLen <= s.length(); i++) {
            if(record.contains(s.substring(i, i + oneWordLen))) res.add(i);
        }
        return res;
    }

    public void reverse(String[] words, int index, int[] used, String s) {
        String newString = s + words[index];
        if(newString.length() == oneWordLen) {
            record.add(newString); return;
        }
        for(int i = 0; i < words.length; i++) {
            if(used[i] == 1) continue;
            used[i] = 1;
            reverse(words, i, used, newString);
            used[i] = 0;
        }
        return;
    }
}
