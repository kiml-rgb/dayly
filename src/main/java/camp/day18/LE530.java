package camp.day18;

import camp.day12.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/8 9:12
 * @description:
 */
public class LE530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getMinDiff(root, list);
        int min = Math.abs(list.get(0) - list.get(1));

        for (int i = 2; i < list.size(); i++) {
            min = Math.min(Math.abs(list.get(i) - list.get(i - 1)), min);
        }

        return min;
    }

    private void getMinDiff(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        getMinDiff(root.left, list);
        list.add(root.val);
        getMinDiff(root.right, list);
    }

    public static void main(String[] args) {

    }

    /**
     * 双指针的解法
     * @param root 根节点
     */
    Integer min = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return min;
        }

        getMinimumDifference1(root.left);

        // 中间遍历
        if (pre != null) {
            min = Math.min(Math.abs(root.val - pre.val), min);
        }
        pre = root;

        getMinimumDifference1(root.right);

        return min;
    }
}
