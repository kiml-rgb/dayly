package huaweiod.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/9 22:12
 * @description:
 */
public class C16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextLine());
        }
        String myChars = scanner.nextLine();

        int count = 0;
        for (String s : list) {
            char[] chars = s.toCharArray();
            count++;
            String newChars = myChars;
            for (char c : chars) {
                if (newChars.contains(String.valueOf(c))) {
                    int i = newChars.indexOf(String.valueOf(c));
                    newChars = getString(newChars, i);
                } else if (newChars.contains("?")) {
                    int i = newChars.indexOf("?");
                    newChars = getString(newChars, i);
                } else {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    private static String getString(String newChars, int i) {
        if (0 < i && i < newChars.length()) {
            newChars = newChars.substring(0, i) + newChars.substring(i + 1);
        } else if (0 == i) {
            newChars = newChars.substring(1);
        } else if (newChars.length() == i) {
            newChars = newChars.substring(0, newChars.length() - 1);
        }
        return newChars;
    }
}
