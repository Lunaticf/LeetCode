package leetCode.linkedList.intersectionOfTwoLinkedLists;

import leetCode.linkedList.ListNode;

import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/9/2
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 1. brute force
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode node = headB;
            while (node != null) {
                if (node == headA) {
                    return node;
                }
                node = node.next;
            }
            headA = headA.next;
        }
        return null;
    }

    /**
     * 移动较长的
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode nodeA = headA;
        while (nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }

        ListNode nodeB = headB;
        while (nodeB != null) {
            lengthB++;
            nodeB = nodeB.next;
        }

        int offset = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (offset-- > 0) {
                headA = headA.next;
            }
        } else {
            while (offset-- > 0) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 最好的做法
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null?headB:a.next;
            b = b == null?headA:b.next;
        }
        return a;
    }
}