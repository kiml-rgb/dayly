package camp.day29;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/6/14 16:52
 * @description:
 */
public class LE406 {
    /**
     * 思路: 先按身高排序, 然后根据前面的人数进行队列调整。
     * @param people 队伍需求
     * @return 排号的队列
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        LinkedList<int[]> list = new LinkedList<>();

        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][]);
    }
}
