package camp.day13;

import camp.day12.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/6/4 9:42
 * @description:
 */
public class LE102 {
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(3);
//        TreeNode leftright = new TreeNode(5);
//        TreeNode rightright = new TreeNode(4);
//        node.left = left;
//        node.right = right;
//        left.right = leftright;
//        right.right = rightright;
//        ArrayList<List<Integer>> resultList = new ArrayList<>();
//        levelOrderDFS(node, 0, resultList);
//        rightSideView(node);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        levelOrderDFS(root, 0, resultList);
        levelOrderBFS(root, resultList);
        return resultList;
    }

    /**
     * 迭代法实现层序遍历（广度优先）
     * @param root 根节点
     * @param resultList 返回的list
     */
    private void levelOrderBFS(TreeNode root, ArrayList<List<Integer>> resultList) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();

            // 遍历所有节点
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);

                // 把这层所有的左节点加入
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 把这层所有的右节点加入
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            resultList.add(list);
        }
    }

    /**
     * 递归方式实现层序遍历(深度优先)
     * @param root 根节点
     * @param i 层数
     * @param resultList 遍历结果
     */
    private static void levelOrderDFS(TreeNode root, int i, ArrayList<List<Integer>> resultList) {
        if (root == null) {
            return;
        }

        i++;

        // 如果小于，说明第一次进这层，需要初始化这个位置的list
        if (resultList.size() < i) {
            ArrayList<Integer> list = new ArrayList<>();
            resultList.add(list);
        }
        resultList.get(i - 1).add(root.val);

        levelOrderDFS(root.left, i, resultList);
        levelOrderDFS(root.right, i, resultList);
    }

    /**
     * LE107
     * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
     * @param root 根节点
     * @return 结果
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        levelOrderDFS(root, 0, resultList);
        Collections.reverse(resultList);
        return resultList;
    }

    static List<Integer> res = new ArrayList<>();
    /**
     * LE199
     * https://leetcode.cn/problems/binary-tree-right-side-view/
     * @param root 根节点
     * @return 结果
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
//        ArrayList<List<Integer>> resultList = new ArrayList<>();
//        levelOrderDFS(root, 0, resultList);
//        for (List<Integer> list : resultList) {
//            integerList.add(list.get(list.size() - 1));
//        }
        rightSideViewDFS(root, 0, integerList);
        return integerList;
    }

    private void rightSideViewDFS(TreeNode root, int i, List<Integer> integerList) {
        if (root == null) {
            return;
        }
        if (i == integerList.size()) {
            integerList.add(root.val);
        }
        rightSideViewDFS(root.right, i + 1, integerList);
        rightSideViewDFS(root.left, i + 1, integerList);
    }
}
