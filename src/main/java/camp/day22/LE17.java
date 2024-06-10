package camp.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/10 15:50
 * @description:
 */
public class LE17 {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * @param digits 按键数组
     * @return 结果
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String[] buttonList = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits == null || "".equals(digits)) {
            return list;
        }

        combinations(0, digits, buttonList, "", list);
        return list;
    }

    /**
     *
     * @param i 遍历的层数
     */
    private static void combinations(int i, String digits, String[] buttonList, String str, List<String> list) {
        if (i == digits.length()) {
            list.add(str);
            return;
        }

        int digit = Integer.parseInt(digits.charAt(i) + "");
        String letter = buttonList[digit];
        for (int j = 0; j < letter.length(); j++) {
            str+=letter.charAt(j);
            combinations(i + 1, digits, buttonList, str, list);
            str = str.substring(0, str.length() - 1);
        }
    }
}
