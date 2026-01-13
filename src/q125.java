import java.util.ArrayList;
import java.util.List;

public class q125 {
    public static boolean isPalindrome(String s) {
        List<Character> record = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'z' <= 0){
                record.add(s.charAt(i));
            } else if(s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'Z' <= 0){
                record.add((char)(s.charAt(i) - 'A' + 'a'));
            } else if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '9' <= 0){
                record.add(s.charAt(i));
            }
        }
        int len = record.size();
        for(int i = 0; i < record.size() / 2 + 1; i++){
            if(record.get(i) != record.get(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
