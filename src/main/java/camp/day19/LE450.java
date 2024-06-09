package camp.day19;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/9 10:57
 * @description:
 */
public class LE450 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node.left = node1;
        node1.left = node3;
        node1.right = node4;
        node.right = node2;
        node2.right = node5;
//        deleteNode(node, 5);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // 为空直接返回
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode right = root.right;
                TreeNode leftRight = root.left.right;
                root = root.left;
                if (leftRight != null) {
                    root.right = leftRight;
                    root.right.right = right;
                } else {
                    root.right = right;
                }
            }
            return root;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
