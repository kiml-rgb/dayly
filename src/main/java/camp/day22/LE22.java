package camp.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/10 15:15
 * @description:
 */
public class LE22 {
    public static void main(String[] args) {
        List<List<Integer>> combinationSum3 = combinationSum3(9, 45);
        for (List<Integer> integerList : combinationSum3) {
            System.out.println(Arrays.toString(integerList.stream().mapToInt(n -> n).toArray()));
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        // 结果集
        List<List<Integer>> result = new ArrayList<>();
        // 单个结果
        List<Integer> list = new ArrayList<>();

        combinationSum(1, k, n, 0, list, result);
        return result;
    }

    private static void combinationSum(int start, int k, int n, int sum, List<Integer> list, List<List<Integer>> result) {
        // 剪枝操作
        if (sum > n) {
            return;
        }

        if (list.size() == k) {
            if (sum == n) {
                List<Integer> resultOne = new ArrayList<>(list);
                result.add(resultOne);
            }
            return;
        }

        for (int j = start; j <= 9 - (k - list.size()) + 1; j++) {
            list.add(j);
            combinationSum(j + 1, k, n, sum + j, list, result);
            list.remove(list.size() - 1);
        }
    }
}
