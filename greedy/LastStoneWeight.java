package leetCode.greedy;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 每个石头有个重量
        // 每一轮，我们选择两个最重的石头，压碎他们 x <= y
        // 如果两个石头相等，一起消失
        // 否则留下y - x
        // 返回最后的石头或者0
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : stones) {
            heap.offer(num);
        }

        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            if (a != b) {
                heap.offer(a - b);
            }
        }

        return heap.size() == 0 ? 0 : heap.poll();
    }
}
