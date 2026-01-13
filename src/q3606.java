import java.util.*;

public class q3606 {
    public static Map<String, Integer> BussinessMap = new HashMap<>();

    static {
        BussinessMap.put("electronics", 1);
        BussinessMap.put("grocery", 2);
        BussinessMap.put("pharmacy", 3);
        BussinessMap.put("restaurant", 4);
    }

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> res = new ArrayList<>();
        List<Integer> activeRec = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (q3606.judgeValid(code[i]) && BussinessMap.get(businessLine[i]) != null && isActive[i]) {
                activeRec.add(i);
            }
        }
        activeRec.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(BussinessMap.get(businessLine[o1]) < BussinessMap.get(businessLine[o2])) {
                    return -1;
                } else if (BussinessMap.get(businessLine[o1]) < BussinessMap.get(businessLine[o2])) {
                    return 1;
                } else {
                    return q3606.getDictSeq(code[o1], code[o2]);
                }
            }
        });
        for (Integer integer : activeRec) {
            res.add(code[integer]);
        }
        return res;
    }

    public static boolean judgeValid(String code){
        if(code.isEmpty()) return false;
        for(int i = 0; i < code.length(); i++){
            if(code.charAt(i) == '_' || (code.charAt(i) - 'a' < 26 && code.charAt(i) - 'a' >= 0) || (code.charAt(i) - 'A' < 26 && code.charAt(i) - 'A' >= 0)
                    || (code.charAt(i) - '0' <= 9 && code.charAt(i) - '0' >= 0)) continue;
            return false;
        }
        return true;
    }

    public static int getDictSeq(String o1, String o2) {
        for(int i = 0; i < o1.length(); i++){
            if(i == o2.length()) return 1;
            if(o1.charAt(i) - 'A' < o2.charAt(i) - 'A') {
                return -1;
            } else if (o1.charAt(i) - 'A' > o2.charAt(i) - 'A') {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] code = {"P9", "t4"};
        String[] businessLine = {"restaurant", "grocery"};
        boolean[] isActive = {true, false};
        System.out.println(validateCoupons(code, businessLine, isActive));
    }
}
