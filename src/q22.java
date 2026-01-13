import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q22 {
    char[] record;

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        record = new char[2 * n];
        Arrays.fill(record, ')');
        reverse(0, 0, 0, n);
        return res;
    }

    public void reverse(int start, int release, int total, int n){
        if(total == n){
            res.add(String.valueOf(record));
            return;
        }
        for(int i = 0; i <= release; i++){
            record[i] = '(';
            reverse(start + 1, i - release + 1, total + 1, n);
            record[i] = ')';
        }
        return;
    }

}
