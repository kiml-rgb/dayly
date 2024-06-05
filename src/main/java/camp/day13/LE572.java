package camp.day13;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/4 11:28
 * @description:
 */
public class LE572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        return isEqual(root, subRoot) || dfs(root.right, subRoot) || dfs(root.left, subRoot);
    }

    private static boolean isEqual(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if ((right == null && left != null) || (right != null && left == null)) {
            return false;
        }
        if (right.val != left.val) {
            return false;
        }

        return isEqual(right.right, left.right) && isEqual(right.left, left.left);
    }
}
