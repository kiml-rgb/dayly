package camp.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/12 9:09
 * @description:
 */
public class LE46 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<List<Integer>> permute = permute(ints);
        for (List<Integer> integers : permute) {
            System.out.println(Arrays.toString(integers.stream().mapToInt(i -> i).toArray()));
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultOne = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        permuteDFS(nums, resultOne, result);
        return result;
    }

    private static void permuteDFS(int[] nums, List<Integer> resultOne, List<List<Integer>> result) {
        if (resultOne.size() == nums.length) {
            result.add(new ArrayList<>(resultOne));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (resultOne.contains(nums[i])) {
                continue;
            }
            resultOne.add(nums[i]);
            permuteDFS(nums, resultOne, result);
            resultOne.remove(resultOne.size() - 1);
        }
    }
}
