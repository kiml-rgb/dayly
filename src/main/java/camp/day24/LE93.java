package camp.day24;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/11 14:08
 * @description:
 */
public class LE93 {
    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("25525511135");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();


        if (s.length() < 4 || s.length() > 12){
            return result;
        }

        restoreIpAddressesDFS(0, temp, s, result);
        return result;
    }

    /**
     *
     * @param startIndex 开始Index
     * @param s 输入的s
     * @param result 切割的字符串集
     */
    private static void restoreIpAddressesDFS(int startIndex, List<String> temp, String s, List<String> result) {
        if (startIndex >= s.length() && temp.size() == 4) {
            String resultOne = String.join(".", temp);
            result.add(resultOne);
        }

        for (int i = startIndex; i < s.length() && Integer.parseInt(s.substring(startIndex, i + 1)) < 256; i++) {
            // 8 为 substring 的取值就在 1 - 3之间
            String substring = s.substring(startIndex, i + 1);
            if (substring.length() < 1 || substring.length() > 3) {
                continue;
            }
            if (substring.length() > 1 && substring.startsWith("0")) {
                continue;
            }
            temp.add(substring);
            restoreIpAddressesDFS(i + 1, temp, s, result);
            temp.remove(temp.size() - 1);
        }
    }

    class Solution {
        List<String> result = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();

        public List<String> restoreIpAddresses(String s) {
            restoreIpAddressesHandler(s, 0, 0);
            return result;
        }

        // number表示stringbuilder中ip段的数量
        public void restoreIpAddressesHandler(String s, int start, int number) {
            // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
            if (start == s.length() && number == 4) {
                result.add(stringBuilder.toString());
                return;
            }
            // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
            if (start == s.length() || number == 4) {
                return;
            }
            // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
            for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                    && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
                // 如果ip段的长度大于1，并且第一位为0的话，continue
                if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                    continue;
                }
                stringBuilder.append(s.substring(start, i + 1));
                // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
                if (number < 3) {
                    stringBuilder.append(".");
                }
                number++;
                restoreIpAddressesHandler(s, i + 1, number);
                number--;
                // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
                stringBuilder.delete(start + number, i + number + 2);
            }
        }
    }
}
