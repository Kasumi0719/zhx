import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class q2785 {
    public static Set<Character> metaChar = new HashSet<>();

    static {
        metaChar.add('a'); metaChar.add('e'); metaChar.add('i'); metaChar.add('o'); metaChar.add('u');
        metaChar.add('A'); metaChar.add('E'); metaChar.add('I'); metaChar.add('O'); metaChar.add('U');
    }

    public static String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> ((int) a - (int) b));
        for(int i = 0; i < s.length(); i++) {
            if(metaChar.contains(s.charAt(i))) {
                pq.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(metaChar.contains(s.charAt(i))) {
                sb.append(pq.poll());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "lEetcOde";
        System.out.println(sortVowels(input));
    }
}
