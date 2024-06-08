package camp.day17;

import camp.day12.TreeNode;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/7 17:02
 * @description:
 */
public class LE654 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree(ints);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int maxIndex = getMaxIndex(nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        if (nums.length == 1) {
            return root;
        }

        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        return root;
    }

    private static int getMaxIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        return maxIndex;
    }
}
