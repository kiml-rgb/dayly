package camp.day18;

import camp.day12.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/6/8 9:37
 * @description:
 */
public class LE501 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.right = node2;
        node2.left = node3;
//        findMode(node1);
    }

//    public static int[] findMode(TreeNode root) {
//        if (root == null) {
//            return new int[]{};
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        find(root, map);
//        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
//                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
//                .collect(Collectors.toList());
//        List<Integer> list = new ArrayList<>();
//        list.add(collect.get(0).getKey());
//        for (int i = 1; i < collect.size(); i++) {
//            if (collect.get(i).getValue().equals(collect.get(0).getValue())) {
//                list.add(collect.get(i).getKey());
//            }
//        }
//        return list.stream().mapToInt(i -> i).toArray();
//    }
//
//    private static void find(TreeNode root, Map<Integer, Integer> map) {
//        if (root == null){
//            return;
//        }
//
//        find(root.left, map);
//        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
//        find(root.right, map);
//    }


    // 双指针的前一个节点
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;

    /**
     * 双指针解法
     * @param root 根节点
     * @return 结果
     */
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 递归逻辑
        findModeTravel(root, list);

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void findModeTravel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        findModeTravel(root.left, list);

        if (pre == null) {
            count = 1;
        }else if (pre.val == root.val){
            count++;
        } else {
            count = 1;
        }
        pre = root;

        if (count == maxCount) {
            list.add(root.val);
        } else if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        }

        findModeTravel(root.right, list);
    }
}
