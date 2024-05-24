package camp.day4;

import camp.day3.LE707;

/**
 * @author ZYF
 * @date: 2024/5/21 9:54
 * @description:
 */
public class LE24 {
    public static void main(String[] args) {
        LE707.MyLinkedList myLinkedList = new LE707.MyLinkedList();
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        swapPairs(myLinkedList.getHead());
    }

    public static LE707.ListNode swapPairs(LE707.ListNode head) {
        LE707.ListNode dumyHead = new LE707.ListNode(-1);
        dumyHead.next = head;

        // 记录当前节点的位置，便于循环
        LE707.ListNode cur = dumyHead;
        while (cur.next != null && cur.next.next != null) {
            // 记录原来，后一个节点需要指向的节点
            LE707.ListNode temp = cur.next.next.next;
            LE707.ListNode node2 = cur.next.next;
            LE707.ListNode node1 = cur.next;

            cur.next = node2;
            cur.next.next = node1;
            cur.next.next.next = temp;
            cur = node1;
        }
        return dumyHead.next;
    }
}
