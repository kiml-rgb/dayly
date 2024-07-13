package camp.day45;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/7/11 17:16
 * @description:
 */
public class LE503 {
    public static void main(String[] args) {
        int[] nextGreaterElements = nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(nextGreaterElements));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % nums.length];
                stack.pop();
            }
            stack.push(i % nums.length);
        }

        return result;
    }
}
