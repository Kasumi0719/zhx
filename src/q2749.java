import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2749 {
    public static int makeTheIntegerZero(int num1, int num2) {
        int res = 1;
        int temp = num1;
        while (temp <= Math.pow(2, 60)) {
            temp = num1 - res * num2;
            if(countBits(temp) == res) {
                return res;
            }
            res++;
        }
        return res;
    }

    public static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            // 检查最低位是否为1
            count += n & 1;
            // 右移一位
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = -2;
        System.out.println(makeTheIntegerZero(num1, num2));
    }
}
