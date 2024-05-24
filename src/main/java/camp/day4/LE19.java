package camp.day4;

import camp.day3.LE707;

/**
 * @author ZYF
 * @date: 2024/5/21 11:15
 * @description:
 */
public class LE19 {
    public static void main(String[] args) {
        LE707.MyLinkedList myLinkedList = new LE707.MyLinkedList();
        myLinkedList.addAtHead(1);
        removeNthFromEnd(myLinkedList.getHead(), 1);
    }

    /**
     * 第一想法是获取长度，然后长度-n得到节点位置。因为节点这个初始化操作之前是写了size的
     * 但是题目中是没有这个初始化操作的。
     * 直接看的解析，说是用快慢双指针的方式。
     */
    public static LE707.ListNode removeNthFromEnd(LE707.ListNode head, int n) {
        // 添加一个虚拟头节点
        LE707.ListNode dumyHead = new LE707.ListNode(-1);
        dumyHead.next = head;

        LE707.ListNode fast = dumyHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        LE707.ListNode slow = dumyHead;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时慢指针指向的为要删除节点的前一个节点
        slow.next = slow.next.next;

        return dumyHead.next;
    }
}
