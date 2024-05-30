package camp.day10;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/5/30 10:05
 * @description:
 */
public class LE20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isValid(scanner.nextLine()));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character pop = stack.pop();
            if ((c == ')' && pop != '(' ) || (c == ']' && pop != '[' ) || (c == '}' && pop != '{' )) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
