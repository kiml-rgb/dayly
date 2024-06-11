package camp.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/11 10:51
 * @description:
 */
public class LE131 {
    public static void main(String[] args) {
        List<List<String>> partition = partition("aab");

        for (List<String> list : partition) {
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> string = new ArrayList<>();
        partitionBFS(0, s, string, result);
        return result;
    }

    private static void partitionBFS(int startIndex, String s, List<String> string, List<List<String>> result) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(string));
        }

        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!isPartition(substring)) {
                continue;
            }
            string.add(substring);
            partitionBFS(i + 1, s, string, result);
            string.remove(string.size() - 1);
        }
    }

    /**
     * 判断传入字符串是否为回文字符串
     * @param substring 截取的字符串
     * @return 结果
     */
    private static boolean isPartition(String substring) {
        for (int i = 0, j= substring.length() - 1; i < j; i++, j--) {
            if (substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
