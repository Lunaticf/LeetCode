package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/14
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        // a little tricky
        // 从后往前找到第一个正序的
        //  1 1 4 5 7 3 4 5
        // i = 5 j = 7
        // 然后把5和5后面更大一点的数交换 后面的数再正序排序
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i >= 0) {
            // 要交换的位置 eg: 5
            int pos = i;
            int j = nums.length - 1;
            // 往回找还可以用二分提速
            for (; j > i; j--) {
                if (nums[j] > nums[pos]) {
                    break;
                }
            }

            swap(nums, i, j);
        }


        reverse(nums, i + 1 );


    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
