package camp.day30;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZYF
 * @date: 2024/6/15 9:08
 * @description:
 */
public class LE452 {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }


    /**
     * 思路：看了一下题目就是要求重叠的区间
     * 关键在于更新最小右边界
     * @param points 坐标点
     * @return 最小弓箭数
     */
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        if (points.length <= 1) {
            return points.length;
        }

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
