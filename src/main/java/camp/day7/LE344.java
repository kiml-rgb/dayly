package camp.day7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/27 9:27
 * @description:
 */
public class LE344 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        reverseString(scanner.nextLine().toCharArray());
    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(Arrays.toString(s));
    }
}
