package camp.day17;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/7 17:29
 * @description:
 */
public class LE617 {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int value1 = root1 == null ? 0 : root1.val;
        int value2 = root2 == null ? 0 : root2.val;

        TreeNode node = new TreeNode(value1 + value2);

        if (root1 == null) {
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        } else if (root2 == null){
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        } else {
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }
        return node;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return root2;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else if (root1 == null && root2 == null) {
            return null;
        } else {
            TreeNode node = new TreeNode(root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
            return node;
        }
    }
}
