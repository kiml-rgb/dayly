package camp.day13;

import camp.day12.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZYF
 * @date: 2024/6/4 9:42
 * @description:
 */
public class LE102 {
    public static void main(String[] args) {

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
    private void levelOrderDFS(TreeNode root, int i, ArrayList<List<Integer>> resultList) {
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
}
