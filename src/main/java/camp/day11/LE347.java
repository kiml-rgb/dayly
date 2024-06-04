package camp.day11;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/6/1 9:45
 * @description:
 */
public class LE347 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] split = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] ints = topKFrequent(split, Integer.parseInt(scanner.nextLine()));
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // map用于计数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) { //依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = pq.poll()[0];
        }
        return ans;

//        return map.entrySet().stream()
//                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
//                .limit(k)
//                .map(Map.Entry::getKey)
//                .mapToInt(i -> i)
//                .toArray();
    }
}
