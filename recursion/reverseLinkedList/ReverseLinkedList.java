package leetCode.recursion.reverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseLinkedList {
    // iterative 需要记住前一个节点
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    // recursion
    // 其实很自然, 首先假设这个函数返回的是新链表的头
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 那么这个函数返回的也是新链表的头
        ListNode p = reverseList(head.next);
        // 此时head依然指向新链表的尾部节点，把head添加到新链表的尾部
        head.next.next = head;
        head.next = null;
        return p;
    }

}
