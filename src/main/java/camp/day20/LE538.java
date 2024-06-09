package camp.day20;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/9 19:28
 * @description:
 */
public class LE538 {
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
//        convertBST(node);
    }


    /**
     * 看了题解之后写出来的
     * 思路：
     * 1.二叉搜索树，中序遍历（左中右）有序
     * 2.要按倒序相加，遍历方向相反
     * 3.取一个指针指向前节点不断累加
     */
    TreeNode pre = new TreeNode(0);
    public TreeNode convertBST(TreeNode root) {
        getTreeNodeTravel(root);
        return root;
    }

    private void getTreeNodeTravel(TreeNode root) {
        if (root == null) {
            return;
        }

        getTreeNodeTravel(root.right);

        root.val = pre.val + root.val;
        pre = root;
        getTreeNodeTravel(root.left);
    }
}
