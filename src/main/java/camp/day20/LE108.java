package camp.day20;

import camp.day12.TreeNode;

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
        return sortedDFS(nums, 0, nums.length);
    }

    private static TreeNode sortedDFS(int[] nums, int i, int j) {
        if (i >= j) {
            return null;
        }

        int mid = (j - i) / 2 + i;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedDFS(nums, i, mid);
        treeNode.right = sortedDFS(nums , mid + 1, j);
        return treeNode;
    }
}
