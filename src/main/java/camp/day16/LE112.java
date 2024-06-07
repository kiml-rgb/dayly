package camp.day16;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/7 9:31
 * @description:
 */
public class LE112 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode leftleft = new TreeNode(7);
        TreeNode leftright = new TreeNode(2);
        node.left = left;
        node.left.left = leftleft;
        node.left.right = leftright;
        System.out.println(hasPathSum(node, 11));
    }


    /**
     * 感觉之前做过求路径的题（递归+迭代）这题应该变换一下
     * @param root 根节点
     * @param targetSum 目标和
     * @return 结果
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        return hasPathSumBFS(root, targetSum);
    }

//    /**
//     * 简化版本
//     */
//    public static boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//
//        if (root.left == null && root.right == null) {
//            return targetSum == 0;
//        }
//
//        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
//    }

    private static boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            // 求list中的总和
            return targetSum == 0;
        }

        if (root.left != null) {
            targetSum -= root.left.val;
            if (hasPathSumBFS(root.left, targetSum)) {
                return true;
            }
            // 这里的回溯就是把当前节点减掉（数值加上）。包括之前也是，但是之前是list不太好移除，所以选择移除最后一位
            targetSum += root.left.val;
        }

        /*
        // 上面三行可以简化成
        if (root.left != null) {
            // 这里targetSum的值是没有变化的。减完的值进入循环，就不用回溯了
            hasPathSumBFS(root.left, targetSum - root.val);
        }
        */

        if (root.right != null) {
            targetSum -= root.right.val;
            if (hasPathSumBFS(root.right, targetSum)) {
                return true;
            }
            targetSum += root.right.val;
        }

        return false;
    }
}
