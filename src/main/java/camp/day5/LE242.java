package camp.day5;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/23 16:00
 * @description:
 */
public class LE242 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(isAnagram1(s, t));
    }

    /**
     * 优化：
     * 改为定义数组去接收数值（其实和map是一样的思想，但是这样代码量更少）
     * 改为第二次遍历，在原数组上直接--（空间用得更少了）
     */
    public static boolean isAnagram1(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路：
     * 1.用map接收每个字符出现的次数
     * 2.比较次数是否相同
     */
    public static boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        HashMap<String, Integer> numMapS = getNumMap(charsS);
        HashMap<String, Integer> numMapT = getNumMap(charsT);

        if (numMapS.size() != numMapT.size()) {
            return false;
        }
        for (String key : numMapS.keySet()) {
            if (!numMapS.get(key).equals(numMapT.get(key))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取每个字符的数量
     * @param charsS 字符串
     * @return 每个字符的数量
     */
    private static HashMap<String, Integer> getNumMap(char[] charsS) {
        HashMap<String, Integer> map = new HashMap<>();
        for (char c : charsS) {
            if (map.containsKey(String.valueOf(c))) {
                map.put(String.valueOf(c) , map.get(String.valueOf(c)) + 1);
            } else {
                map.put(String.valueOf(c), 1);
            }
        }
        return map;
    }
}
