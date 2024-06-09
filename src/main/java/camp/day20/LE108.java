package camp.day20;

import camp.day12.TreeNode;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/9 17:58
 * @description:
 */
public class LE108 {
    public static void main(String[] args) {
        int[] ints = {-10, -3, 0, 5, 9};
        sortedArrayToBST(ints);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedBFS(nums, 0, nums.length);
    }

    private static TreeNode sortedBFS(int[] nums, int i, int j) {
        if (i >= j) {
            return null;
        }

        int mid = (j - i) / 2 + i;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedBFS(nums, i, mid);
        treeNode.right = sortedBFS(nums , mid + 1, j);
        return treeNode;
    }
}
