package huaweiod.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/10 21:18
 * @description:
 */
public class C17 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String[] s = scanner.nextLine().split(" ");

            int k = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int m = Integer.parseInt(s[2]);


            List<String> list = new ArrayList<>();
            while (k > 0) {
                list.add(String.valueOf(k % m));
                k = k / m;
            }

            int count = 0;
            for (String string : list) {
                if (string.equals(String.valueOf(n))) {
                    count++;
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            System.out.println(0);
        }
    }
}
