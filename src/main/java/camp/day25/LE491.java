package camp.day25;

import java.util.*;

/**
 * @author ZYF
 * @date: 2024/6/11 16:12
 * @description:
 */
public class LE491 {
    public static void main(String[] args) {
        int[] ints = {4,4,3,2,1};
        List<List<Integer>> subsequences = findSubsequences(ints);
        for (List<Integer> subsequence : subsequences) {
            System.out.println(Arrays.toString(subsequence.stream().mapToInt(i -> i).toArray()));
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultOne = new ArrayList<>();

        findSubsequencesDFS(0 , nums, resultOne, result);
        return result;
    }

    private static void findSubsequencesDFS(int startIndex, int[] nums, List<Integer> resultOne, List<List<Integer>> result) {
        // 先这样判断是否重复
        if (resultOne.size() >= 2) {
            result.add(new ArrayList<>(resultOne));
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (resultOne.size() != 0 && resultOne.get(resultOne.size() - 1) > nums[i]) {
                continue;
            }
            // 判断这层是否使用
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            resultOne.add(nums[i]);
            findSubsequencesDFS(i + 1, nums, resultOne, result);
            resultOne.remove(resultOne.size() - 1);
        }
    }
}
