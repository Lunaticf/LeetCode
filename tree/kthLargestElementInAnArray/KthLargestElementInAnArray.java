package leetCode.tree.kthLargestElementInAnArray;

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


}
