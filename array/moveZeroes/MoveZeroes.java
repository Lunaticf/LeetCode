package LeetCode.array.moveZeroes;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }


}
