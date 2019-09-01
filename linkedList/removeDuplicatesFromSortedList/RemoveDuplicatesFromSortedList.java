package leetCode.linkedList.removeDuplicatesFromSortedList;

import leetCode.linkedList.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // corner case
        if (head == null || head.next == null) return head;

        ListNode p = head.next;
        ListNode prev = head;

        while (p != null) {
            // 如果与前一个值相同
            if (p.val == prev.val) {
                prev.next = p.next;
                p = prev.next;
            } else {
                prev = p;
                p = p.next;
            }
        }

        return head;
    }

    // simplify
    public ListNode deleteDuplicates1(ListNode head) {
        // corner case
        if (head == null || head.next == null) return head;

        ListNode p = head;

        while (p.next != null) {
            // 如果与后一个值相同
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }
}
