package camp.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/3 9:46
 * @description: 包括144、94、145的递归求法
 */
public class LE144 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    /**
     * 后序遍历
     * @param root 节点
     * @param list 遍历结果
     */
    private void postOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    /**
     * 中序遍历
     * @param root 节点
     * @param list 遍历结果
     */
    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /**
     * 前序遍历
     * @param root 节点
     * @param list 遍历结果
     */
    private void preOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        // 当前
        list.add(root.val);
        // 左子树
        preOrder(root.left, list);
        // 右子树
        preOrder(root.right, list);
    }
}
