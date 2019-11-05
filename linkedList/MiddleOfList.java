package leetCode.linkedList;

public class MiddleOfList {
    // 先算长度 two pass
    public ListNode middleNode1(ListNode head) {
        // 返回中间节点 如果有两个 返回第二个
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }


        for (int i = 0; i < len / 2; i++) {
            head = head.next;
        }
        return head;
    }

    // 双指针
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
