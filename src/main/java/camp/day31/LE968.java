package camp.day31;

import camp.day12.TreeNode;

/**
 * @author ZYF
 * @date: 2024/6/17 15:06
 * @description:
 */
public class LE968 {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (minCameraCoverTravel(root) == 0) {
            res++;
        }
        return res;
    }

    private int minCameraCoverTravel(TreeNode root) {
        if (root == null) {
            // 空节点默认为有覆盖的状态
            return 2;
        }

        // 后续遍历
        int left = minCameraCoverTravel(root.left);
        int right = minCameraCoverTravel(root.right);

        // 前两个if可以互换
        // 情况1
        if (left == 2 && right == 2) {
            return 0;
        // 情况2，加一个摄像头
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else {
            return 2;
        }
    }
}
