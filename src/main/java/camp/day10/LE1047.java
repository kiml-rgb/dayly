package camp.day10;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/5/30 10:22
 * @description:
 */
public class LE1047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(removeDuplicates(scanner.nextLine()));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder str = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }
}
