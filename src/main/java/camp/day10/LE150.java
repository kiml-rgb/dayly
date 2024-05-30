package camp.day10;

import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/5/30 10:54
 * @description:
 */
public class LE150 {
    public static void main(String[] args) {

    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num = Integer.parseInt(tokens[0]);
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    num = stack.pop() + stack.pop();
                    stack.push(num);
                    break;
                }
                case "-": {
                    Integer num2 = stack.pop();
                    Integer num1 = stack.pop();
                    num = num1 - num2;
                    stack.push(num);
                    break;
                }
                case "*": {
                    num = stack.pop() * stack.pop();
                    stack.push(num);
                    break;
                }
                case "/": {
                    Integer num2 = stack.pop();
                    Integer num1 = stack.pop();
                    num = num1 / num2;
                    stack.push(num);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return num;
    }
}
