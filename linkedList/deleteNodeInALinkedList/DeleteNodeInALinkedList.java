package leetCode.linkedList.deleteNodeInALinkedList;

import leetCode.linkedList.ListNode;

/**
 * @Author Lunaticf
 * @Date 2019/9/16
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next  = node.next.next;
    }
}
