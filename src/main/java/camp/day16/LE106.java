package camp.day16;

import camp.day12.TreeNode;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/7 10:00
 * @description:
 */
public class LE106 {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        buildTree(inorder, postorder);
    }

    /**
     * 1.后序最后一个节点为根节点
     * 2.根据这个节点切割中序数组（节点前为左子树，节点后为右子树）
     * 3.根据中序数组的切割切割后序数组
     * 4.递归
     * @param inorder 中序遍历结果
     * @param postorder 后序遍历结果
     * @return 树
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) {
            return root;
        }

        int indexIn = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                indexIn = i;
                break;
            }
        }
        // 左子树
        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, indexIn);
        // 右子树
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, indexIn + 1, inorder.length);

        root.left = buildTree(leftTreeInorder, Arrays.copyOfRange(postorder, 0, leftTreeInorder.length));
        root.right = buildTree(rightTreeInorder, Arrays.copyOfRange(postorder, leftTreeInorder.length, postorder.length - 1));
        return root;
    }
}
