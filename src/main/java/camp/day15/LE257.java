package camp.day15;

import camp.day12.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/6/6 9:44
 * @description:
 */
public class LE257 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftright = new TreeNode(5);
        TreeNode rightright = new TreeNode(4);
        node.left = left;
        node.right = right;
        left.right = leftright;
        right.right = rightright;
        binaryTreePaths(node);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> pathString = new ArrayList<>();
        if (root == null) {
            return pathString;
        }
        List<Integer> path = new ArrayList<>();
        binaryTree(root, path, pathString);
        return pathString;
    }

    private static void binaryTree(TreeNode root, List<Integer> path, List<String> pathString) {
        path.add(root.val);

        if (root != null && (root.right == null && root.left == null)) {
            pathString.add(path.stream().map(Object::toString).collect(Collectors.joining("->")));
            return;
        }

        if (root.left != null) {
            binaryTree(root.left, path, pathString);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            binaryTree(root.right, path, pathString);
            path.remove(path.size() - 1);
        }
    }
}
