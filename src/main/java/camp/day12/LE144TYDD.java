package camp.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/6/4 9:00
 * @description: 统一迭代法
 */
public class LE144TYDD {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                // 判断右节点
                if (node.right != null) {
                    stack.push(node.right);
                }
                // 左节点
                if (node.left != null) {
                    stack.push(node.left);
                }
                // 中间节点
                stack.push(node);
                stack.push(null);
                // 只有到最后一个节点，才会进这个else
            } else {
                // 遇到空节点，说明后一个是要处理的节点，先弹出空节点
                stack.pop();

                // 再把要处理的节点弹出并加入到列表中
                node = stack.peek();
                stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * @param root 根节点
     * @return 返回遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                // 判断右节点
                if (node.right != null) {
                    stack.push(node.right);
                }
                // 中间节点
                stack.push(node);
                stack.push(null);
                // 左节点
                if (node.left != null) {
                    stack.push(node.left);
                }
                // 只有到最后一个节点，才会进这个else
            } else {
                // 遇到空节点，说明后一个是要处理的节点，先弹出空节点
                stack.pop();

                // 再把要处理的节点弹出并加入到列表中
                node = stack.peek();
                stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                // 中间节点
                stack.push(node);
                stack.push(null);
                // 判断右节点
                if (node.right != null) {
                    stack.push(node.right);
                }
                // 左节点
                if (node.left != null) {
                    stack.push(node.left);
                }
                // 只有到最后一个节点，才会进这个else
            } else {
                // 遇到空节点，说明后一个是要处理的节点，先弹出空节点
                stack.pop();

                // 再把要处理的节点弹出并加入到列表中
                node = stack.peek();
                stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }
}
