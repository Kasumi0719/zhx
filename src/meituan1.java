import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class meituan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 使用 TreeMap 保证类别和年月的自然排序
        Map<String, Map<String, int[]>> stats = new TreeMap<>();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String[] orderInfo = scanner.nextLine().split(" ");
            String productName = orderInfo[0];
            String category = orderInfo[1];
            int quantity = Integer.parseInt(orderInfo[2]);
            int amount = Integer.parseInt(orderInfo[3]);
            String dateStr = orderInfo[4];

            // 解析日期，提取年月部分（YYYY-MM）
            LocalDate date = LocalDate.parse(dateStr, dateFormatter);
            String yearMonth = date.getYear() + "-" + String.format("%02d", date.getMonthValue());

            // 更新统计信息
            stats.computeIfAbsent(category, k -> new TreeMap<>())
                    .compute(yearMonth, (k, v) -> {
                        if (v == null) {
                            return new int[]{quantity, amount};
                        } else {
                            v[0] += quantity;
                            v[1] += amount;
                            return v;
                        }
                    });
        }

        // 输出结果
        for (Map.Entry<String, Map<String, int[]>> categoryEntry : stats.entrySet()) {
            String category = categoryEntry.getKey();
            Map<String, int[]> yearMonthStats = categoryEntry.getValue();

            for (Map.Entry<String, int[]> entry : yearMonthStats.entrySet()) {
                String yearMonth = entry.getKey();
                int totalQuantity = entry.getValue()[0];
                int totalAmount = entry.getValue()[1];

                System.out.println(category + " " + yearMonth + " " + totalQuantity + " " + totalAmount);
            }
        }
    }
}