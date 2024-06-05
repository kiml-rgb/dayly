package camp.day13;

import camp.day12.TreeNode;

import java.util.ArrayList;

/**
 * @author ZYF
 * @date: 2024/6/4 10:14
 * @description:
 */
public class LE226 {

    /**
     * DFS递归
     * @param root 根节点
     * @return 翻转结果
     */
    public TreeNode invertTree(TreeNode root) {
        invertTreePreorder(root);
        return root;
    }

    private void invertTreePreorder(TreeNode root) {
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
