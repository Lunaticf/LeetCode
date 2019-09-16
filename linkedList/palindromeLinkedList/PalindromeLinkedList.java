package leetCode.linkedList.palindromeLinkedList;

import leetCode.linkedList.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/9/16
 */
public class PalindromeLinkedList {
    // 普通做法 转移到别的数据结构 就好判断了
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!list.get(i++).equals(list.get(j--))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1->2->2->1
     * 1->2->2->2->1
     * slow最终都会停在正确的位置
     * @param
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 先确定middle point
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // 将slow指向的链表逆置
        slow = reverseLinkedList(slow);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newHead = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}
