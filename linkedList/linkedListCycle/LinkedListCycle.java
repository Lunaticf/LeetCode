package LeetCode.linkedList.linkedListCycle;

import LeetCode.linkedList.ListNode;

import java.util.HashSet;

public class LinkedListCycle {
    // 1. hashtable
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) return true;
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    // 2. two pointers
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}
