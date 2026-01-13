import java.util.ArrayList;

public class q151 {
    public String reverseWords(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(s.charAt(start) == ' ') start++;
        while(s.charAt(end) == ' ') end--;
        char[] record = new char[end - start + 1];
        return "";
    }
}
