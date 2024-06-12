package camp.day21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/10 9:58
 * @description:
 */
public class LE77 {
    public static void main(String[] args) {
//        combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combineDFS(1, n, k, list, result);
        return result;
    }

    /**
     *
     * @param start 当前开始节点
     * @param n n
     * @param k k
     * @param list 每个list
     * @param result 最后的结果
     */
    private void combineDFS(int start, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            List<Integer> resultOne = new ArrayList<>(k);
            resultOne.addAll(list);
            result.add(resultOne);
            return;
        }

        for (int j = start; j <= (n - (k - list.size())) + 1; j++) {
            list.add(j);
            combineDFS(j + 1, n, k, list, result);
            list.remove(list.size() - 1);
        }
    }
}

