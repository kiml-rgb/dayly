package huaweiod.day7;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/9 22:02
 * @description:
 */
public class C15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        int count = 0;
        for (Integer task : list) {
            sum += task;
            sum = sum > max ? sum - max : 0;
            count++;
        }

        if (sum > 0) {
            count = count + new BigDecimal(sum).divide(new BigDecimal(max), BigDecimal.ROUND_UP).intValue();
        }
        System.out.println(count);
    }
}
