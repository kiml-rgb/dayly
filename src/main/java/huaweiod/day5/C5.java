package huaweiod.day5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/6 15:19
 * @description:
 */
public class C5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            int num = Integer.parseInt(scanner.nextLine());

            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                arrayList.add(scanner.nextLine());
            }

            String s = scanner.nextLine();
            String[] split = s.split(" ");

            int i = Integer.parseInt(split[0]);
            int count = 0;
            for (String string : arrayList) {
                String[] strings = string.substring(1).split("/");

                if (strings.length >= i && strings[i - 1].equals(split[1])) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
