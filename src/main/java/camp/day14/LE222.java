package camp.day14;

import camp.day12.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZYF
 * @date: 2024/6/5 9:49
 * @description:
 */
public class LE222 {
    public static void main(String[] args) {

    }


//    /**
//     * 普通二叉树求节点
//     * @param root 根节点
//     * @return 结果
//     */
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int leftNum = countNodes(root.left);
//        int rightNum = countNodes(root.right);
//        return 1 + leftNum + rightNum;
//    }

//    int depth = 0;
//    int num = 0;
//    ArrayList<List<Integer>> list = new ArrayList<>();
//
//    /**
//     * 普通二叉树求节点（层序遍历）
//     * 写一遍怕忘记了
//     *
//     * @param root 根节点
//     * @return 结果
//     */
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        depth++;
//
//        if (list.size() < depth) {
//            ArrayList<Integer> innerList = new ArrayList<>();
//            list.add(innerList);
//            if (root != null) {
//                num++;
//            }
//        }
//
//        countNodes(root.right);
//        countNodes(root.left);
//
//        return num;
//    }

//    /**
//     * 普通二叉树求节点 迭代法（层序遍历）
//     * 写一遍怕忘记了
//     *
//     * @param root 根节点
//     * @return 结果
//     */
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int num = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                num++;
//                if (cur.left != null) {
//                    queue.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    queue.offer(cur.right);
//                }
//            }
//        }
//        return num;
//    }

    /**
     * 完全二叉树求节点
     * @param root 根节点
     * @return 结果
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        int leftLength = 0, rightLength = 0;
        while (left != null) {
            left = left.left;
            leftLength++;
        }
        while (right != null) {
            right = right.right;
            rightLength++;
        }
        if (leftLength == rightLength) {
            return (2 << leftLength) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
