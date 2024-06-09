package camp.day19;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/9 9:49
 * @description:
 */
public class LE235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return lowestCommonAncestorTravel(root, p, q);
        } else {
            return lowestCommonAncestorTravel(root, q, p);
        }
    }

    private TreeNode lowestCommonAncestorTravel(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (p.val <= root.val && root.val <= q.val)) {
            return root;
        } else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
