package leetCode.array.removeDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[q] != nums[p]) {
                p++;
                nums[p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }

    // more brief
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != nums[i]) {
                nums[++i] = num;
            }
        }
        return i + 1;
    }
}
