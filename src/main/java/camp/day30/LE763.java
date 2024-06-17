package camp.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/15 10:21
 * @description:
 */
public class LE763 {
    /**
     * 思路：
     * 1. 找到每个字母的区间
     * 2. 根据遍历中最远结束节点，更新切割位置
     * @param s 字符串
     * @return 结果
     */
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();

        // 记录每个字母最后出现的节点
        int[] ints = new int[26];
        Arrays.fill(ints, -1);
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i] - 'a'] = i;
        }

        List<Integer> list = new ArrayList<>();

        int idx = 0;
        // 记录上一个切割的位置（用于计算存入list的长度）
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            // 把节点更新为要结束的地方
            idx = Math.max(idx, ints[chars[i] - 'a']);
            // 直到可以结束
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}

