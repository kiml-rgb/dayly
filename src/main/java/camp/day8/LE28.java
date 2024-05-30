package camp.day8;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/29 9:04
 * @description:
 */
public class LE28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.nextLine();
        String needle = scanner.nextLine();
        System.out.println(strStr1(haystack, needle));
    }

    /**
     * 思路：一个指针针对haystack遍历，一个指针针对needle遍历
     * 当指针指过的路径相等，输出两者的差（即初始相等的指针位置）
     * 当指向元素不同，haystack指针指向初始对比的下一个，needle指针重置
     */
    public static int strStr(String haystack, String needle) {
        int j = 0;
        if (needle.length() == 0) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return  -1;
    }

    /**
     * 思路：使用KMP算法。
     * 之前双指针移动，不相等haystack的指针返回到初始匹配位置的下一位（暴力求解）
     * 现在使用KMP算法，不相等移动到next表中标记的位置。
     * 所以现在的关键就在于next表的计算：
     * 1.初始化
     * 2.当前后缀不相等时的思路（回退）
     * 3.当前后缀相等时的思路（继续后移）
     */
    public static int strStr1(String haystack, String needle) {
        // 获取Next表
        int[] ints = new int[needle.length()];
        int[] next = getNext(ints, needle);

        int j = 0;
        if (needle.length() == 0) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            // 不相等, j回退
            while (j != 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 相等
            if (haystack.charAt(i) == needle.charAt(j)) {
                // 完全匹配，返回下标
                if (j == needle.length() - 1) {
                    return i - j;
                }
                j++;
            }

        }
        return  -1;
    }

    /**
     * 获取next表，例：
     * a a b a a f
     * 0 1 0 1 2 0
     *
     * 1.初始化
     * 2.当前后缀不相等时的思路（回退）
     * 3.当前后缀相等时的思路（继续后移）
     *
     * @param next 返回的next数组
     * @param s 要求的字符串
     * @return next数组
     */
    private static int[] getNext(int[] next, String s) {
        // 初始化 两个指针i和j，j指向前缀末尾位置(同时也是之前最长相等的前后缀长度)，i指向后缀末尾位置(随着字符串长度递增，递增)。
        // 刚刚初始化时，字符串为a，所以j = 0
        int j = 0;
        next[0] = j;

        // 这里i从1开始，没有搞懂(因为初始位置一定为0吗)
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
