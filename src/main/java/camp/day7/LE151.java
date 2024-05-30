package camp.day7;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/28 10:19
 * @description:
 */
public class LE151 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(reverseWords(scanner.nextLine()));
    }

    private static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            String trim = split[i].trim();
            if ("".equals(trim)) {
                continue;
            }
            stringBuilder.append(trim).append(" ");
        }

        return stringBuilder.toString().trim();
    }

//    /**
//     * 本题考察点应该和上一题一样
//     * 步骤如下:
//     * 1.移除字符串中的空格
//     * 2.倒序
//     * 3.每个单词再反转
//     * 要求：不使用任何内置API
//     */
//    public static String reverseWords(String s) {
//        String removeSpace = removeSpace(s);
//        System.out.println(removeSpace);
//        return reverseWord(removeSpace);
//    }

    /**
     * 单个单词倒置
     */
    private static String reverseWord(String s) {
        String[] list = s.split(" ");
        if (list.length <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : list) {
            char[] chars = s1.toCharArray();
            for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            stringBuilder.append(chars).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    /**
     * 去除字符串中的多余空格
     * 并进行倒序
     */
    private static String removeSpace(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        if (start > end) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = end; i >= start; i--) {
            if (chars[i] == ' ' && chars[i - 1] == ' ') {
                continue;
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

}
