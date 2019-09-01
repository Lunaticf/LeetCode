package leetCode.recursion.swapNodesInPairs;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class SwapNodesInPairs {

    // recursion
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        // swap
        ListNode second = head.next;
        ListNode third = head.next.next;

        second.next = head;
        head.next = swapPairs(third);

        return second;
    }

    // iterative
    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // swap start
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;

        }

        return dummy.next;
    }
}


