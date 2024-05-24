package camp.day4;

import camp.day3.LE707;

/**
 * @author ZYF
 * @date: 2024/5/22 11:44
 * @description:
 */
public class LE142 {
    public LE707.ListNode detectCycle(LE707.ListNode head) {
        LE707.ListNode fast = head;
        LE707.ListNode slow = head;

        while (fast!= null  && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 找到相遇点
            if (slow == fast) {
                LE707.ListNode index1 = head;
                LE707.ListNode index2 = fast;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
