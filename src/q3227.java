import java.util.HashSet;
import java.util.Set;

public class q3227 {
    public static Set<Character> metaChar = new HashSet<>();

    static {
        metaChar.add('a'); metaChar.add('e'); metaChar.add('i'); metaChar.add('o'); metaChar.add('u');
    }

    public static boolean doesAliceWin(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(metaChar.contains(s.charAt(i))) count++;
        }
        return count != 0;
    }

    public static void main(String[] args) {
        String input = "bbdc";
        System.out.println(doesAliceWin(input));
    }
}
