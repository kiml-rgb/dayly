package camp.day30;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZYF
 * @date: 2024/6/15 9:45
 * @description:
 */
public class LE435 {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2, 3}}));

    }

    /**
     * 思路：和上一题差不多，找重叠的，然后移除了
     * @param intervals 区间的集合
     * @return 结果
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int count = 0;

        if (intervals.length <= 1) {
            return count;
        }

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]){
            } else {
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }

        return count;
    }
}
