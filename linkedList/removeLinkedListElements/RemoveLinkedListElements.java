package leetCode.linkedList.removeLinkedListElements;

import leetCode.linkedList.ListNode;

import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/9/12
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }


    /**
     * recur
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements1(head.next, val);
        }

        head.next = removeElements1(head.next, val);

        return head;
    }
}
