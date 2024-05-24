package huaweiod.day5;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/6 18:17
 * @description:
 * 有点怪，没有说步数为0怎么走。
 */
public class C9 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int count = Integer.parseInt(scanner.nextLine());

            if (count < 1 || count > 100) {
                throw new Exception();
            }
            int num = Integer.parseInt(scanner.nextLine());
            if (num < -100 || num > 100) {
                throw new Exception();
            }

            String[] split = scanner.nextLine().split(" ");
            int max = 0;
            int point = 0;
            for (int i = 0; i < count; i++) {
                if (Integer.parseInt(split[i]) < -100 || Integer.parseInt(split[i]) > 100) {
                    throw new Exception();
                }

                int step = Integer.parseInt(split[i]);

                if (step == num) {
                    if (step > 0) {
                        step = step + 1;
                    } else if (step < 0) {
                        step = step - 1;
                    }
                }

                point = point + step;
                max = Math.max(max, point);
            }
            System.out.println(max);
        } catch (Exception e) {
            System.out.println("12345");
        }
    }
}
