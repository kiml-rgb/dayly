package huaweiod.day1;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author ZYF
 * @date: 2024/3/28 21:24
 * @description:
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        if (in.hasNextLine()) {
            sum = in.nextInt();
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        while (in.hasNextLine() && sum > 0) {
            treeSet.add(in.nextInt());
            sum--;
        }

        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }
}
