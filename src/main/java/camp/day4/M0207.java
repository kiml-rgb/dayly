package camp.day4;

import camp.day3.LE707;

/**
 * @author ZYF
 * @date: 2024/5/21 11:42
 * @description:
 */
public class M0207 {
    public static void main(String[] args) {
        LE707.MyLinkedList myLinkedList1 = new LE707.MyLinkedList();
        myLinkedList1.addAtTail(4);
        myLinkedList1.addAtTail(1);
        myLinkedList1.addAtTail(8);
        myLinkedList1.addAtTail(4);
        myLinkedList1.addAtTail(5);

        LE707.MyLinkedList myLinkedList2 = new LE707.MyLinkedList();
        myLinkedList2.addAtTail(5);
        myLinkedList2.addAtTail(0);
        myLinkedList2.addAtTail(1);
        myLinkedList2.addAtTail(8);
        myLinkedList2.addAtTail(4);
        myLinkedList2.addAtTail(5);

        getIntersectionNode(myLinkedList1.getHead(), myLinkedList2.getHead());
    }

    /**
     * 思路：最后都会合成到一个链
     * 可以把两个链按末尾对其，即较长链的指针起始与短链对齐
     * @param headA headA
     * @param headB headB
     * @return 相交部分
     */
    public static LE707.ListNode getIntersectionNode(LE707.ListNode headA, LE707.ListNode headB) {
        int intersectVal = 0;
        int skipA = 0;
        int skipB = 0;

        LE707.ListNode tempA = headA;
        LE707.ListNode tempB = headB;

        int sizeA = 0;
        while (tempA != null) {
            sizeA++;
            tempA = tempA.next;
        }

        int sizeB = 0;
        while (tempB != null) {
            sizeB++;
            tempB = tempB.next;
        }

        if (sizeA == 0 || sizeB == 0) {
            return null;
        }

        tempA = headA;
        tempB = headB;
        // 尾端对其
        if (sizeA >= sizeB) {
            for (int i = 0; i < (sizeA - sizeB); i++) {
                tempA = tempA.next;
                skipA++;
            }
        } else {
            for (int i = 0; i < (sizeB - sizeA); i++) {
                tempB = tempB.next;
                skipB++;
            }
        }

        // 不相同，指针后移
        while (tempA != null) {
            if (tempA == tempB) {
                intersectVal = tempA.val;
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
            skipA++;
            skipB++;
        }

        return null;
    }

    /**
     * 思路：最后都会合成到一个链
     * 可以把两个链按末尾对其，即较长链的指针起始与短链对齐
     * @param headA headA
     * @param headB headB
     * @return 相交部分
     */
    public static LE707.ListNode getIntersectionNode2(LE707.ListNode headA, LE707.ListNode headB) {
        int intersectVal = 0;
        int skipA = 0;
        int skipB = 0;

        LE707.ListNode tempA = headA;
        LE707.ListNode tempB = headB;

        int sizeA = 0;
        while (tempA != null) {
            sizeA++;
            tempA = tempA.next;
        }

        int sizeB = 0;
        while (tempB != null) {
            sizeB++;
            tempB = tempB.next;
        }

        if (sizeA == 0 || sizeB == 0) {
            return null;
        }

        tempA = headA;
        tempB = headB;
        // 尾端对其
        if (sizeA >= sizeB) {
            for (int i = 0; i < (sizeA - sizeB); i++) {
                tempA = tempA.next;
                skipA++;
            }
        } else {
            for (int i = 0; i < (sizeB - sizeA); i++) {
                tempB = tempB.next;
                skipB++;
            }
        }

        // 不相同，指针后移
        while (tempA != null) {
            if (tempA == tempB) {
                intersectVal = tempA.val;
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
            skipA++;
            skipB++;
        }

        return null;
    }
}
