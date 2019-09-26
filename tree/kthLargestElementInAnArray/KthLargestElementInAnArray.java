package leetCode.tree.kthLargestElementInAnArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        // 排序 O(NlogN)
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        // 建堆O(N) 找第k个为O(kLogN)
        buildHeap(nums);
        // 最后复杂度O(N)
        for (int i = 0; i < k - 1; i++) {
            // 删去第一个元素
            nums[0] = nums[nums.length - 1 - i];
            downJust(nums, 0, nums.length - i - 1);
        }
        return nums[0];
    }

    // 建堆
    private void buildHeap(int[] nums) {
        // 对于每个非叶子结点，将其下沉
        for (int i = (nums.length - 2) / 2;i >= 0; i--) {
            downJust(nums, i, nums.length);
        }
    }

    // 下沉操作 用于删除堆顶元素
    private void downJust(int[] nums, int i, int length) {
        int j = i * 2 + 1;
        if (i * 2 + 2 < length) {
            j = nums[i*2 + 1] > nums[i*2 + 2] ? i * 2 + 1: i*2 + 2;
        }

        // 将该结点与子节点中较大的结点做交换
        while (nums[j] > nums[i]) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;

            i = j;
            if (i * 2 + 2 < length) {
                j = nums[i*2 + 1] > nums[i*2 + 2] ? i * 2 + 1: i*2 + 2;
            }
        }

    }

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val :nums) {
            priorityQueue.offer(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    // quick sort
    public int findKthLargest3(int[] nums, int k) {
       if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
       return findKthLargest3(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargest3(int[] nums, int start, int end, int k) {
        if (start > end) return Integer.MAX_VALUE;
        int pivot = nums[end];
        int left = start;

        for(int i = start; i < end; i++) {
           if (nums[i] <= pivot) {
               swap(nums, left++, i);
           }
        }
        swap(nums, left, end);

        if (left == k) {
            return nums[left];
        } else if (left < k) {
            return findKthLargest3(nums, left + 1, end, k);
        } else {
            return findKthLargest3(nums, start, left - 1, k);
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
