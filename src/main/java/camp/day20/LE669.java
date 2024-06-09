package camp.day20;

import camp.day12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZYF
 * @date: 2024/6/9 16:05
 * @description:
 */
public class LE669 {

    public static void main(String[] args) {
//        trimBST(tree, 1, 1);
    }


    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        if (root.val > high) {
//            return root.left;
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            // 继续向右遍历
//            return root.right;
            return trimBST(root.right, low, high);
        }

        if (low <= root.val && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }

        while (root != null && (root.val < low || root.val > high)) {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                // 删除这个节点
                // 1.右子树补位(找到右子树的最左侧节点)
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
            }
        }
        return root;
    }


//    /**
//     * 思路：查找节点，删除节点
//     * @param root 根节点
//     * @param low 区间左范围
//     * @param high 区间右范围
//     * @return
//     */
//    public static TreeNode trimBST(TreeNode root, int low, int high) {
//        if (root == null) {
//            return root;
//        }
//        // 先剪枝
//        cut(root, low, high);
//        // 再减单个
//        return travel(root, low, high);
//    }
//
//    private static TreeNode travel(TreeNode root, int low, int high) {
//        if (root == null) {
//            return root;
//        }
//
//        if (root.val > high) {
//            root.right = null;
//        }
//        if (root.val < low) {
//            root.left = null;
//        }
//
//        if (low <= root.val && root.val <= high) {
//            root.left = travel(root.left, low, high);
//            root.right = travel(root.right, low, high);
//        } else {
//            if (root.left == null) {
//                return root.right;
//            } else if (root.right == null) {
//                return root.left;
//            }else {
//                // 删除这个节点
//                // 1.右子树补位(找到右子树的最左侧节点)
//                TreeNode cur = root.right;
//                while (cur.left != null) {
//                    cur = cur.left;
//                }
//                cur.left = root.left;
//                root = root.right;
//
//                return root;
//            }
//        }
//
//        root.left = travel(root.left, low, high);
//        root.right = travel(root.right, low, high);
//        return root;
//    }
//
//    private static void cut(TreeNode root, int low, int high) {
//        if (root == null) {
//            return;
//        }
//
//        // 整条剪掉
//        if (root.val > high) {
//            root.right = null;
//        }
//        if (root.val < low) {
//            root.left = null;
//        }
//        cut(root.left, low, high);
//        cut(root.right, low, high);
//    }
}
