package huaweiod.day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/6 18:02
 * @description:
 */
public class C8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        int l1 = Integer.parseInt(s1[0]);
        int l2 = Integer.parseInt(s1[1]);

        String[] cpuAString = scanner.nextLine().split(" ");
        String[] cpuBString = scanner.nextLine().split(" ");

        List<Integer> cpuAList = Arrays.stream(cpuAString).sorted(Comparator.comparingInt(Integer::parseInt))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> cpuBList = Arrays.stream(cpuBString).sorted(Comparator.comparingInt(Integer::parseInt))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        long sumA = cpuAList.stream().collect(Collectors.summarizingInt(i -> i)).getSum();
        long sumB = cpuBList.stream().collect(Collectors.summarizingInt(i -> i)).getSum();

        for (Integer cpuA : cpuAList) {
            for (Integer cpuB : cpuBList) {
                if (cpuA - cpuB == (sumA - sumB) / 2) {
                    System.out.println(cpuA + " " + cpuB);
                    return;
                }
            }
        }

    }
}
