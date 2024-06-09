package camp.day18;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/8 10:05
 * @description:
 */
public class LE236 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return root也是空 可以和下面一起写
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!= null && right != null) {
            return root;
        } else if (left != null && right == null) {
            return left;
        } else if (right != null && left == null) {
            return right;
        } else {
            return null;
        }
    }
}
