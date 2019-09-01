package leetCode.array.removeElement;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (val != num) {
                nums[i++] = num;
            }
        }
        return i + 1;
    }

    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return len;
    }
}
