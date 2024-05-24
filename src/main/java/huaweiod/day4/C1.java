package huaweiod.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/4 22:29
 * @description:
 *
 */
public class C1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextInt());
        }

        String collect = arrayList.stream().sorted((o1, o2) -> {
            if (Math.abs(o1 - h) - Math.abs(o2 - h) == 0) {
                return o1 - o2;
            }
            return Math.abs(o1 - h) - Math.abs(o2 - h);
        }).map(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(collect);
    }
}
