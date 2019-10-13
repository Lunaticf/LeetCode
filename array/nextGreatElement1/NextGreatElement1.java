package leetCode.array.nextGreatElement1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreatElement1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1, 3, 4, 2};
//        new NextGreatElement1().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.binarySearch(nums2, 2));
    }

    /**
     * brute force
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 就是对于nums1中的每个元素，在nums2中先找到其元素，再往后找更大的元素
        // nums1是nums2的子集
        // brute force O(N^2)
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // 定位到该数
            int j = 0;
            while (nums2[j] != nums1[i]) {
                j++;
            }


            // 找更大的数
            while (j < nums2.length && nums2[j] <= nums1[i]) {
                j++;
            }

            if (j < nums2.length) {
                res[i] = nums2[j];
            } else {
                res[i] = -1;
            }

        }
        return res;
    }


    /**
     * [4,1,2]
     * [1,3,4,2]
     * stack 和 map
     * 1 => 3 3比1大 所以1的下一个大的数字就是3 我们就往map里面put(1, 3)
     * 3 => 4 所以map里面put(3, 4)
     * 4 => 2 所以这两个都是-1
     * stack O(N)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(16);


        for (int num : nums2) {
            while (!stack.empty() && num > stack.peek()) {
                int temp = stack.pop();
                map.put(temp, num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
