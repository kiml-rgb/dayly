package camp.day17;

import camp.day12.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/7 17:56
 * @description:
 */
public class LE98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        if (list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 单次循环搞定
     */
    TreeNode max;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST1(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        return isValidBST1(root.right);
    }
}
