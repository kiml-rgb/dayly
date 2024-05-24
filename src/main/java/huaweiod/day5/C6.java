package huaweiod.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/6 15:59
 * @description:
 */
public class C6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s1 = new String[0];
        String[] s2 = new String[0];
        int num = 0;
        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            s1 = s.split(" ");
        }

        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            s2 = s.split(" ");
        }

        if (scanner.hasNextLine()) {
            num = Integer.parseInt(scanner.nextLine());
        }

        List<Integer> list = new ArrayList<>();
        for (String string1 : s1) {
            for (String string2 : s2) {
                list.add(Integer.parseInt(string1) + Integer.parseInt(string2));
            }
        }

        list = list.stream().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum = sum + list.get(i);
        }

        System.out.println(sum);
    }
}
