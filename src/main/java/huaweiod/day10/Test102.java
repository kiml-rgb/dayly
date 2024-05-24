package huaweiod.day10;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author ZYF
 * @date: 2024/4/14 14:06
 * @description:
 */
public class Test102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int j = 0; j < i; j++) {
            int k = Integer.parseInt(scanner.nextLine());
            treeSet.add(k);
        }

        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }
}
