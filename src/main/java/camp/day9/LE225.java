package camp.day9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZYF
 * @date: 2024/5/30 9:21
 * @description:
 */
public class LE225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("myStack.top() = " + myStack.top());
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack.empty() = " + myStack.empty());
    }

    static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            int size = queue.size() - 1;
            while (size != 0) {
                size--;
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        /**
         * 判断是否为空
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
