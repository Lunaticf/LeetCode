package leetCode.linkedList;

import java.util.List;

public class RemoveLinkedList {
    /**
     * one pass怎么做
     * 双指针 p q q先走n就行了呀
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        // 定位结束
        ListNode prev = dummy;
        while (q != null) {
            q = q.next;
            prev = p;
            p = p.next;
        }

        prev.next = p.next;
        return dummy.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 移除末尾第n个节点
        // 显然two pass很简单
        // 如何one pass

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int len = 0;
        ListNode p = dummy;
        while (p != null) {
            len++;
            p = p.next;
        }

        int forwardN = len - n;
        p = dummy;
        ListNode prev = p;
        for (int i = 0; i < forwardN; i++) {
            prev = p;
            p = p.next;
        }

        prev.next = p.next;
        p = null;
        return dummy.next;
    }
}
