import java.util.HashMap;
import java.util.Map;

public class q3305 {

    Map<Character, Integer> dict = new HashMap<>();

    public int countOfSubstrings(String word, int k) {
        initialize();
        int count = 5;
        int release = k;
        int result = 0;
        int left = 0;
        int right = 0;
        while(right < word.length()){
            if(dict.containsKey(word.charAt(right))){
                dict.put(word.charAt(right), dict.get(word.charAt(right)) - 1);
                if(dict.get(word.charAt(right)) == 0) count--;
            }else{
                release--;
            }
            if(release == 0 && count == 0) result++;
            while(release < 0  && left <= right){
                if(dict.containsKey(word.charAt(left))){
                    dict.put(word.charAt(left), dict.get(word.charAt(left)) + 1);
                    if(dict.get(word.charAt(left)) == 1) count++;
                }else{
                    release++;
                }
                if(count == 0) result++;
                left++;
            }
            if(right == word.length() - 1){
                while(count == 0 && release == 0){
                    if(dict.containsKey(word.charAt(left))){
                        dict.put(word.charAt(left), dict.get(word.charAt(left)) + 1);
                        if(dict.get(word.charAt(left)) == 1) count++;
                    }else{
                        release++; break;
                    }
                    if(count == 0) result++;
                    left++;
                }
            }
            right++;
        }
        return result;
    }

    public void initialize(){
        dict.put('a', 1);
        dict.put('e', 1);
        dict.put('i', 1);
        dict.put('o', 1);
        dict.put('u', 1);
    }
}
