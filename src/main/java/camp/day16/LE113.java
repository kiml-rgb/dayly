package camp.day16;

import camp.day12.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/7 14:52
 * @description:
 */
public class LE113 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode leftleft = new TreeNode(7);
        TreeNode leftright = new TreeNode(2);
        node.left = left;
        node.left.left = leftleft;
        node.left.right = leftright;
        System.out.println(pathSum(node, 11));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        pathSumBFS(root, targetSum, result, list);
        return result;
    }

    private static void pathSumBFS(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }

        targetSum -= root.val;
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                List<Integer> arrayList = new ArrayList<>(list);
                result.add(arrayList);
            }
        }

        if (root.left != null) {
            pathSumBFS(root.left, targetSum, result, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            pathSumBFS(root.right, targetSum, result, list);
            list.remove(list.size() - 1);
        }
    }
}
