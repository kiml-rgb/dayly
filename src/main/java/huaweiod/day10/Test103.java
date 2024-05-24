package huaweiod.day10;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/14 14:10
 * @description:
 */
public class Test103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Integer.parseInt(s.substring(2), 16));
    }
}
