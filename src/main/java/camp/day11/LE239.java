package camp.day11;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * @author ZYF
 * @date: 2024/5/31 10:46
 * @description:
 */
public class LE239 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] split = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] ints = maxSlidingWindow(split, Integer.parseInt(scanner.nextLine()));
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 定义一个单调队列
     */
    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int num) {
            while (!deque.isEmpty() && num > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(num);
        }

        /**
         * 判断队顶元素是否是要移除的元素
         */
        public void pull(int num) {
            if (!deque.isEmpty() && deque.peek() == num) {
                deque.poll();
            }
        }

        public int peek() {
            return deque.peek();
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }

        int j = 0;
        int[] ints = new int[nums.length - k + 1];
        ints[j++] = myQueue.peek();
        for (int i = k; i <nums.length; i++) {
            // 窗口滑动，移除元素（移除时要判断元素是否在单调队列内）
            myQueue.pull(nums[i - k]);
            // 窗口滑动，添加最新元素到单调队列
            myQueue.push(nums[i]);
            // 获取单调队列队顶元素（根据定义的规则，一定是区间内最大的）
            ints[j++] = myQueue.peek();
        }
        return ints;
    }


//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length <= k) {
//            return new int[]{getMax(nums, 0, nums.length - 1)};
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i <= nums.length - k; i++) {
//            int max = getMax(nums, i, i + k - 1);
//            list.add(max);
//        }
//        return list.stream().mapToInt(i -> i).toArray();
//    }
//
//    private static int getMax(int[] nums, int i, int j) {
//        int max = Integer.MIN_VALUE;
//        for (int k = i; k <= j; k++) {
//            max = Math.max(max, nums[k]);
//        }
//        return max;
//    }
}
