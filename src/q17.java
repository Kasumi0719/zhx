import java.util.ArrayList;
import java.util.List;

public class q17 {
    public String[] dict = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public StringBuffer record = new StringBuffer();

    public List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        reverse(digits, 0);
        return result;
    }

    public void reverse(String digits, int index){
        if(index >= digits.length()){
            result.add(record.toString());
            return;
        }
        for(int i = 0; i < dict[digits.charAt(index) - '2'].length(); i++){
            record.append(dict[digits.charAt(index) - '2'].charAt(i));
            reverse(digits, index + 1);
            record.delete(record.length() - 1, record.length());
        }
        ArrayList<String> temp = new ArrayList<>();
        return ;
    }
}
