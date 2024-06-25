package camp.day37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/25 10:35
 * @description:
 */
public class LE139 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak("leetcode", list);
    }

    /**
     * 思路：
     * 1. 字典中的单词可以重复使用（完全背包）
     * 2. 排列顺序不同算两种情况（排列）
     * <p>
     * 难点：
     * dp数组大小无法直接定义
     *
     * @param s        要拼接的字符串
     * @param wordDict 字典
     * @return 结果
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[s.length()];
    }

    public static boolean wordBreakBFS(String s, List<String> wordDict, List<String> word) {
        String join = String.join("", word);
        if (s.length() <= join.length()) {
            return s.equals(String.join("", word));
        } else if (!s.startsWith(join)) {
            return false;
        }

        for (String string : wordDict) {
            word.add(string);
            boolean b = wordBreakBFS(s, wordDict, word);
            if (b) {
                return true;
            }
            word.remove(word.size() - 1);
        }

        return false;
    }
}
