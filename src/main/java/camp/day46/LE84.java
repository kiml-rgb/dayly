package camp.day46;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/7/16 16:20
 * @description:
 */
public class LE84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 首末尾加零防止无法进入循环
        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i < newHeights.length - 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        newHeights[heights.length + 1] = 0;
        newHeights[0] = 0;

        int area = 0;
        stack.push(0);
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                // 当前元素的前一个元素
                Integer mid = stack.pop();
                // 右侧数据与左侧数据的差值
                int w = i - stack.peek() - 1;
                area = Math.max(area, w * newHeights[mid]);
            }
            stack.push(i);
        }

        return area;
    }
}
