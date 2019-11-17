package leetCode.linkedList;

import java.util.Random;

public class RandomNode {
    /**
     * 难点在于如果不能知道长度呢？
     * 水塘抽样 Reservoir Sampling
     * https://zhuanlan.zhihu.com/p/29178293
     */


    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private Random random;
    private ListNode head;
    public RandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode cur = head;
        int count = 0;
        int res = 0;

        while(cur != null){
            int ran = random.nextInt(count + 1);
            if(ran == count){
                res = cur.val;
            }
            count++;
            cur = cur.next;
        }

        return res;
    }

}
