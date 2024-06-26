package camp.day38;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/26 10:58
 * @description:
 */
public class LE337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] dp = robDFS(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] robDFS(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = robDFS(root.left);
        int[] right = robDFS(root.right);

        return new int[]{Math.max(left[0], left[1]) + Math.max(right[0], right[1]), root.val + left[0] + right[0]};
    }
}
