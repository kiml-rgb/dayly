package camp.day3;

import java.util.SortedMap;

/**
 * @author ZYF
 * @date: 2024/5/15 10:18
 * @description:
 */
public class LE206 {

    public static void main(String[] args) {
        LE707.MyLinkedList myLinkedList = new LE707.MyLinkedList();
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.setHead(reverseList(myLinkedList.getHead()));
        myLinkedList.get(0);
    }

    public static LE707.ListNode reverseList(LE707.ListNode head) {
        LE707.ListNode pre = null;
        LE707.ListNode cur = head;
        while (cur != null) {
            LE707.ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static class LinkedList {
        private LE203.ListNode head;

        public LE203.ListNode getHead() {
            return head;
        }

        public void setHead(LE203.ListNode head) {
            this.head = head;
        }

        public LE203.ListNode getCurrent() {
            return current;
        }

        public void setCurrent(LE203.ListNode current) {
            this.current = current;
        }

        private LE203.ListNode current;

        public void add(int val) {
            if (head == null) {
                head = new LE203.ListNode(val);
                current = head;
            } else {
                current.next = new LE203.ListNode(val);
                current = current.next;
            }
        }
    }
}
