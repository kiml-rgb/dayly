package camp.day14;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/5 9:25
 * @description:
 */
public class LE111 {
    /**
     * 思路：
     * 递归终止条件
     * 1.根节点为空，直接返回0
     * 2.根节点的左右节点有一个为空，返回另一个节点的最小深度
     *
     * @param root 根节点
     * @return 结果
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }
}
