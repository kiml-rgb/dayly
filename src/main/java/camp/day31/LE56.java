package camp.day31;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/17 9:08
 * @description:
 */
public class LE56 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 10}, {4, 5}, {6, 7}, {8, 9}})));
    }

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        // 按左边界排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        if (intervals.length <= 1) {
            return intervals;
        }

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 没有重合区间，将上一个合并区间加入list，并更新最新的合并区间
            if (intervals[i][0] > intervals[i - 1][1]) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
                // 更新合并的右边界
            } else {
                end = Math.max(end, intervals[i][1]);
                // 更新右边界
                intervals[i][1] = end;
            }
        }
        // 最后需要将最后一个合并区间加入
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }
}
