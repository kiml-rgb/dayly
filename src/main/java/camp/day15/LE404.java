package camp.day15;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/6 11:01
 * @description:
 */
public class LE404 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightleft = new TreeNode(15);
        TreeNode rightright = new TreeNode(7);
        node.left = left;
        node.right = right;
        right.left = rightleft;
        right.right = rightright;
        System.out.println(sumOfLeftLeaves(node));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * 关键在于怎么判断该节点是左叶子节点
     *
     * @param root 根节点
     * @return 结果
     */
    public static void getSum(TreeNode root, Integer sum) {

    }
}
