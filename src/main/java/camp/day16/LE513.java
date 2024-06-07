package camp.day16;

import camp.day12.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/6/7 9:13
 * @description:
 */
public class LE513 {
    public static void main(String[] args) {

    }

    /**
     * 看题目感觉层序遍历简单一点
     * @param root 根节点
     * @return 结果
     */
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        findBottomDFS(root, 0, list);
        List<Integer> theLastLayer = list.get(list.size() - 1);
        return theLastLayer.stream().filter(Objects::nonNull).collect(Collectors.toList()).get(0);
    }

    private void findBottomDFS(TreeNode root, int i, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        // 深度增加
        i++;

        if (list.size() < i) {
            ArrayList<Integer> innerList = new ArrayList<>();
            list.add(innerList);
        }
        list.get(i - 1).add(root.val);

        findBottomDFS(root.left, i, list);
        findBottomDFS(root.right, i, list);
    }

    int value;
    int maxDeep = Integer.MIN_VALUE;
    public int findBottomLeftValueBFS(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > maxDeep) {
                value = root.val;
                maxDeep = deep;
            }
        }

        if (root.left != null) {
            findLeftValue(root.left, deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right, deep + 1);
        }
    }
}
