package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author Lunaticf
 * @Date 2019/10/29
 */
public class  KthLargest {
//    private List<Integer> data;
//    private int k;
//
//    // 插入排序
//    public KthLargest(int k, int[] nums) {
//        Arrays.sort(nums);
//        this.data = new ArrayList<>();
//        for (int num : nums) {
//            data.add(num);
//        }
//        this.k = k;
//    }
//
//    public int add(int val) {
//        for (int i = data.size() - 1; i >= -1; i--) {
//            if (i == -1 || val >= data.get(i)) {
//                data.add(i + 1, val);
//                break;
//            }
//        }
//
//        return data.get(data.size() - k);
//    }


    // 或者用优先队列 但是丢掉了很多元素呢
    private PriorityQueue<Integer> priorityQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
       this.k = k;
       priorityQueue = new PriorityQueue<>(k);
       for (int a : nums){
           add(a);
       }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

}
