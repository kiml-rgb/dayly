package camp.day14;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/5 9:11
 * @description:
 */
public class LE104 {
    /**
     * 思路：递归计算左右子树的深度。取较大值
     * @param root 根节点
     * @return 结果
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        return 1 + Math.max(leftLength, rightLength);
    }

//    /**
//     * 递归法(求深度法) 前序遍历
//     * @param root 根节点
//     * @return 结果
//     */
//    public int maxDepth1(TreeNode root) {
//        int maxNum = 0;
//        ans(root, 0, maxNum);
//        return maxNum;
//    }
//
//    private void ans(TreeNode root, int i, int maxNum) {
//        if (root == null) {
//            return;
//        }
//        i++;
//        maxNum = Math.max(i, maxNum);
//        ans(root.left, i, maxNum);
//        ans(root.right, i, maxNum);
//        i--;
//    }
}
