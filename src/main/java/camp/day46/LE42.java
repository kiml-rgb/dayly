package camp.day46;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/7/13 9:32
 * @description:
 */
public class LE42 {
    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int area = 0;

        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            // 当前元素小于栈顶元素
            if (height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // 当前的栈顶
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int w = i - stack.peek() - 1;
                        area += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return area;
    }
}
