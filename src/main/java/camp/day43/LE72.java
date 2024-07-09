package camp.day43;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/7/8 19:31
 * @description:
 */
public class LE72 {
    public static void main(String[] args) {
        int i = minDistance("horse", "ros");
        System.out.println(i);
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 三数比较
                    // word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
                    // word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
                    // 替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增删加元素。
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[word1.length()][word2.length()];
    }
}
