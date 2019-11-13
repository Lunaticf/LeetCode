package leetCode.linkedList;

/**
 * @Author Lunaticf
 * @Date 2019/11/13
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int a = l1 == null?0:l1.val;
            int b = l2 == null?0:l2.val;
            p.next = new ListNode((a + b + carry) % 10);
            p = p.next;
            carry = (a + b + carry) / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return head.next;
    }
}
