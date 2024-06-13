package camp.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/12 11:17
 * @description:
 */
public class LE332 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("JFK", "SFO"));
        list.add(Arrays.asList("JFK", "ATL"));
        list.add(Arrays.asList("SFO", "ATL"));
        list.add(Arrays.asList("ATL", "JFK"));
        list.add(Arrays.asList("ATL", "SFO"));

        List<String> itinerary = findItinerary(list);
        for (String s : itinerary) {
            System.out.println(s);
        }
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> resultOne = new ArrayList<>();

        // 按字典排序排序
        tickets.sort(Comparator.comparing(o -> o.get(1)));
        // 用于记录当前节点是否使用
        boolean[] flagList = new boolean[tickets.size()];

        // 行程必须从JFK开始
        resultOne.add("JFK");

        // 这里如果找到一条就直接返回
        findItineraryDFS(flagList, tickets, resultOne);
        return resultOne;
    }

    private static boolean findItineraryDFS(boolean[] flagList, List<List<String>> tickets, List<String> resultOne) {
        // tickets为线路数，节点数要加1
        if (resultOne.size() == tickets.size() + 1) {
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            // 如果这张票和上张票相同 且上张票没用过 说明是从上张票回溯过来的，已经遍历过这种情况，跳过
            if (i > 0 && tickets.get(i).equals(tickets.get(i - 1)) && !flagList[i - 1]) {
                continue;
            }

            if (!flagList[i] && tickets.get(i).get(0).equals(resultOne.get(resultOne.size() - 1))) {
                resultOne.add(tickets.get(i).get(1));
                flagList[i] = true;

                if (findItineraryDFS(flagList, tickets, resultOne)) {
                    return true;
                }

                resultOne.remove(resultOne.size() - 1);
                flagList[i] = false;
            }
        }
        return false;
    }
}
