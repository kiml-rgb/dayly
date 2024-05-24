package huaweiod.day1;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZYF
 * @date: 2024/3/28 22:14
 * @description:
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 10);
        map.put("B", 11);
        map.put("C", 12);
        map.put("D", 13);
        map.put("E", 14);
        map.put("F", 15);

        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
            next = next.substring(2);

            int sum = 0;
            char[] chars = next.toUpperCase().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    sum = sum + (int) Math.pow(16, (chars.length - i - 1)) * map.get(Character.toString(chars[i]));
                } else {
                    sum = sum + (int) Math.pow(16, (chars.length - i - 1)) * Integer.parseInt(Character.toString(chars[i]));
                }
            }
            System.out.println(sum);
        }

//        // 额.方法二
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String next = scanner.nextLine();
//            System.out.println(Integer.parseInt(next.substring(2), 16));
//        }
    }
}
