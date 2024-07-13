package camp.day45;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/7/11 15:19
 * @description:
 */
public class LE739 {
    public static void main(String[] args) {
        int[] dp = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}
