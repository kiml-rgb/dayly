package huaweiod.day8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/10 22:02
 * @description:
 */
public class C18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Integer> abilities = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int min = Integer.parseInt(scanner.nextLine());

        int l = 0;
        int r = num - 1;
        int count = 0;
        while (l < r && abilities.get(r) >= min) {
            count++;
            r--;
        }

        while (l < r) {
            if (abilities.get(l) + abilities.get(r) >= min) {
                count++;
                l++;
                r--;
            } else {
                l++;
            }
        }

        if (l == r && abilities.get(l) >= min) {
            count++;
        }

        System.out.println(count);
    }
}
