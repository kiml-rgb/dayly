package camp.day3;

/**
 * @author ZYF
 * @date: 2024/5/13 16:54
 * @description:
 */
public class LE707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        // 链表变为 1->2->3
        myLinkedList.addAtIndex(1, 2);
        // 返回 2
        myLinkedList.get(1);
        // 现在，链表变为 1->3
        myLinkedList.deleteAtIndex(1);
        // 返回 3
        myLinkedList.get(1);
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class MyLinkedList {
        private int size;
        private ListNode head;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public ListNode getHead() {
            return head;
        }

        public void setHead(ListNode head) {
            this.head = head;
        }

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index <= -1 || index >= size) {
                return -1;
            }

            ListNode indexNode = head;
            for (int i = 0; i < index; i++) {
                indexNode = indexNode.next;
            }

            return indexNode.val;
        }

        public void addAtHead(int val) {
            if (size == 0) {
                size++;
                head = new ListNode(val);
                return;
            }
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (index < 0) {
                index = 0;
            }

            ListNode pre = head;
            // 找到前一个节点的位置
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }

            ListNode listNode = new ListNode(val);
            // 如果插入节点为头节点
            if (index == 0) {
                listNode.next = pre;
                head = listNode;
                // 长度++
                size++;
                return;
            }
            // 如果插入位置正好是尾节点 直接前节点指向这个节点 然后return
            if (index == size) {
                pre.next = listNode;
                // 长度++
                size++;
                return;
            }

            // 否则
            // 先把当前节点的后指针指向前节点的next
            listNode.next = pre.next;
            // 再把前节点的后指针指向当前节点
            pre.next = listNode;
            // 长度++
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }

            ListNode pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            // 如果删除节点为头节点
            if (index == 0) {
                head = head.next;
                size--;
                return;
            }
            // 如果删除位置正好是尾节点 直接前节点指向null 然后return
            if (index + 1 == size) {
                pre.next = null;
                // 长度++
                size--;
                return;
            }
            // 改变当前节点的前节点的后指针，指向下一个节点
            pre.next = pre.next.next;
            // 长度--
            size--;
        }
    }
}
