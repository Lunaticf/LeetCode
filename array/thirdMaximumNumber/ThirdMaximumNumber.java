package leetCode.array.thirdMaximumNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        // 默认是最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            // 如果是新的元素
            if (set.add(num)) {
                priorityQueue.offer(num);

                // 使其维持在3个元素
                if (priorityQueue.size() > 3) {
                    priorityQueue.poll();
                }
            }
        }

        // 如果只有2个元素 返回最大的即可
        if (priorityQueue.size() == 2) priorityQueue.poll();
        return priorityQueue.peek();
    }

    public int thirdMax1(int[] nums) {
        // 或者直接用TreeSet 一步到位
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3) {
                treeSet.pollFirst();
            }
        }
        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }

    // 迭代的方式 个人不喜欢这种用包装类型来判断的
    // 但是效率还是比较高
    public int thirdMax2(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            // 如果n > max1 需要replace
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

}
