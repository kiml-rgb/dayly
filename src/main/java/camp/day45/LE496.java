package camp.day45;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/7/11 16:05
 * @description:
 */
public class LE496 {
    public static void main(String[] args) {
        int[] nextGreaterElement = nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
        System.out.println(Arrays.toString(nextGreaterElement));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    // num1中包含整这个元素
                    if (map.containsKey(nums2[stack.peek()])) {
                        // result中的对应下标为这个元素的后一位
                        result[map.get(nums2[stack.peek()])] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}
