package camp.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/6/3 10:28
 * @description: 迭代法
 */
public class LE144DD {
    /**
     * 迭代法
     * 前序遍历 中左右
     * @param root 根节点
     * @return 结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);

            // 栈先进后出，先进右
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return list;
    }

    /**
     * 迭代法
     * 中序遍历 左中右
     * @param root 根节点
     * @return 结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                // 先遍历左子节点(直至到最后一个左子节点)
                stack.push(cur);
                cur = cur.left;
            } else {
                // 此时从栈里弹出的数据，就是要处理的数据
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }

    /**
     * 后序遍历 左右中
     * @param root 根节点
     * @return 结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);

            // 栈先进后出，先进右
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        // 上部分代码与前序相同，left和right遍历顺序颠倒。得到的数组为中右左遍历得出的结果
        // 翻转得到的结果，即为左右中遍历得出的结果
        Collections.reverse(list);
        return list;
    }

}
