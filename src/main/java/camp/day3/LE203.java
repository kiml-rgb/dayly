package camp.day3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/24 21:40
 * @description:
 */
public class LE203 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if ("".equals(s.trim())) {
            System.out.println(new LinkedList());
            return;
        }
        List<Integer> head = Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int val = Integer.parseInt(scanner.nextLine());

        // 初始化链表
        LinkedList linkedList = new LinkedList();
        for (Integer integer : head) {
            linkedList.add(integer);
        }


        ListNode listNode = removeElements(linkedList.head, val);
        System.out.println(listNode);
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return pre;
    }

    /**
     * 链表的定义
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class LinkedList {
        private ListNode head;

        public ListNode getHead() {
            return head;
        }

        public void setHead(ListNode head) {
            this.head = head;
        }

        public ListNode getCurrent() {
            return current;
        }

        public void setCurrent(ListNode current) {
            this.current = current;
        }

        private ListNode current;

        public void add(int val) {
            if (head == null) {
                head = new ListNode(val);
                current = head;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }
    }
}
