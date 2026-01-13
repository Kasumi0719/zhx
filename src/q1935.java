import java.util.HashSet;
import java.util.Set;

public class q1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> record = new HashSet<>();
        for(int i = 0; i < brokenLetters.length(); i++){
            record.add(brokenLetters.charAt(i));
        }
        String[] words = text.split(" ");
        int res = 0;
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                if(record.contains(word.charAt(i))) break;
                if(i == word.length() - 1) res++;
            }
        }
        return res;
    }
}
