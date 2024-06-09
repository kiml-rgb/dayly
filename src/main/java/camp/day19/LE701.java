package camp.day19;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/9 10:12
 * @description:
 */
public class LE701 {

    //    TreeNode pre;
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (pre == null) {
//            if (root == null) {
//                return new TreeNode(val);
//            }
//        } else {
//            if (root == null) {
//                if (pre.val > val){
//                    pre.left = new TreeNode(val);
//                } else if (pre.val < val) {
//                    pre.right = new TreeNode(val);
//                }
//                return root;
//            }
//        }
//        pre = root;
//
//        if (root.val > val) {
//            insertIntoBST(root.left, val);
//        } else if (root.val < val) {
//            insertIntoBST(root.right, val);
//        }
//
//        return root;
//    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            // 递归创建右子树
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            // 递归创建左子树
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
