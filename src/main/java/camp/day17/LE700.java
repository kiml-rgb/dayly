package camp.day17;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/7 17:42
 * @description:
 */
public class LE700 {
    /**
     * BFS
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    /**
     * DFS
     */
    public TreeNode searchBSTDFS(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            } else if (val < root.val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

}
