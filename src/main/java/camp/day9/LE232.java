package camp.day9;

import java.util.Stack;

/**
 * @author ZYF
 * @date: 2024/5/30 9:05
 * @description:
 */
public class LE232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.pop() = " + queue.pop());
        System.out.println("queue.empty() = " + queue.empty());
    }

    static class MyQueue {
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            // 把in的内容复制到out
            in2out();
            return stackOut.pop();
        }

        private void in2out() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }

        /**
         * 返回列表开头的数据
         * @return 结果
         */
        public int peek() {
            // 把in的内容复制到out
            in2out();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.empty() && stackOut.empty();
        }
    }
}
