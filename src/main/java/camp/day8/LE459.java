package camp.day8;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/29 11:05
 * @description:
 */
public class LE459 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        System.out.println(repeatedSubstringPattern1(nextLine));
    }

    /**
     * 思路:暴力解法，循环判断是否重复
     */
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * KMP思路
     * 如果这个字符串是由重复子串组成的，那么字符串长度-最长相等前后缀就为重复子串的长度
     * 反过来说，如果一个字符串的最长相等前后缀与长度的差值（即可能是重复子串长度的这个值）能被字符串长度整除，那么就说明这个字符串是由重复子串组成的
     * 但是这个反过来说。需要证明。（虽然画了几种情况都是这样）
     *
     * KMP思路：
     * 1.初始化
     * 2.不相等的情况
     * 3.相等的情况
     */
    public static boolean repeatedSubstringPattern1(String s) {
        int[] next = getNext(s);
        // 这里除了上面说的条件之外，还需要加上next[len - 1] != -1, 这说明字符串有最长相同的前后缀（就是字符串里的前缀子串和后缀子串相同的最长长度）
        return next[s.length() - 1] != 0 && s.length() % (s.length() - next[s.length() - 1]) == 0;
    }

    private static int[] getNext(String s) {
        int j = 0;
        int[] next = new int[s.length()];
        next[j] = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j != 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }
}
