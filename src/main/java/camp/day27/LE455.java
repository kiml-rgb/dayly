package camp.day27;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/13 9:23
 * @description:
 */
public class LE455 {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g, s));
    }


    /**
     * 感觉上s从小排序，g从小排序。按序分配就行。
     * @param g 孩子胃口
     * @param s 饼干数
     * @return 结果
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
        }
        return count;
    }
}
