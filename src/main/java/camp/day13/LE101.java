package camp.day13;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/4 10:42
 * @description:
 */
public class LE101 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        isSymmetric(node);
    }

    /**
     * 这题和翻转放在一起
     * 第一思路就是翻转之后比较是否相等(但是是指针引用，翻转之后是不能进行比较的)
     * 看了部分讲解，说是把左子，右子拆分成两棵树来看.
     * 可以拆分之后翻转一棵树，然后比较是否相等。
     *
     * 看完解析后的思路，不用翻转直接比较是否相等
     *
     * @param root 根节点
     * @return 结果
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;

        return compare(right, left);
    }

    private static boolean compare(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if ((right == null && left != null) || (right != null && left == null)) {
            return false;
        }
        if (right.val != left.val) {
            return false;
        }

        return compare(right.right, left.left) && compare(right.left, left.right);
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

    private static void invertTreePreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp;
        // 指针交换
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            invertTreePreorder(root.left);
        }
        if (root.right != null) {
            invertTreePreorder(root.right);
        }
    }
}
