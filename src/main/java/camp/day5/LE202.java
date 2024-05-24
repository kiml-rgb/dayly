package camp.day5;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/23 17:23
 * @description:
 */
public class LE202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isHappy(Integer.parseInt(s)));
    }

    /**
     * 思路：放到set中，重复或者为1，跳出循环
     * @param n 数
     * @return 是否是快乐数
     */
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int sum = 0;
            while (n > 0) {
                int temp = n % 10;
                sum += temp * temp;
                n = n / 10;
            }
//            for (int i = 0; i < num.length(); i++) {
//                sum += Math.pow(Integer.parseInt(num.charAt(i) + ""), 2);
//            }

            if (sum == 1) {
                return true;
            }

            if (set.contains(sum)) {
                return false;
            }
            n = sum;
            set.add(sum);
        }
    }
}
