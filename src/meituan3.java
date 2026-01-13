import java.util.*;

public class meituan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countBeautifulNumbers(n));
    }

    public static int countBeautifulNumbers(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] is_prime = new boolean[n + 1];
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (is_prime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    is_prime[multiple] = false;
                }
            }
        }

        boolean[] is_beautiful = new boolean[n + 1];
        for (int p = 2; p <= n; p++) {
            if (is_prime[p]) {
                for (int x = p; x <= p * p && x <= n; x += p) {
                    is_beautiful[x] = true;
                }
            }
        }

        int count = 0;
        for (int x = 2; x <= n; x++) {
            if (is_beautiful[x]) {
                count++;
            }
        }
        return count;
    }
}