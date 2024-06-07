package camp.day16;

import camp.day12.TreeNode;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/7 16:10
 * @description:
 */
public class LE105 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        int indexIn = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                indexIn = i;
                break;
            }
        }
        // 左子树
        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, indexIn);
        // 右子树
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, indexIn + 1, inorder.length);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, leftTreeInorder.length + 1), leftTreeInorder);
        root.right = buildTree(Arrays.copyOfRange(preorder, inorder.length - rightTreeInorder.length, inorder.length), rightTreeInorder);
        return root;
    }
}
