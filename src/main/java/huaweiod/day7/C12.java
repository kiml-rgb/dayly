package huaweiod.day7;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/9 10:11
 * @description:
 */
public class C12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int xNum = 0;
        int yNum = 0;
        int count = 0;
        for (char aChar : chars) {
            if (aChar == 'X') {
                xNum++;
            } else {
                yNum++;
            }
            if (xNum == yNum) {
                count++;
                xNum = 0;
                yNum = 0;
            }
        }
        System.out.println(count);
    }
}
