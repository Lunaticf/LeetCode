package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/7
 */
public class SortColor {

    public void sortColors(int[] nums) {
        // one pass也可以
        // 明显就是三路划分嘛 这里1是mid, 左边只有0 右边只有2
        int i = 0, j = 0, n = nums.length - 1;
        while ( j <= n) {
            if (nums[j] == 0) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;i++;
            } else if (nums[j] == 2) {
                nums[j] = nums[n];
                nums[n] = 2;
                n--;
            } else {
                j++;
            }
        }
    }


    public void sortColors1(int[] nums) {
        // two pass
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) zero++;
            if (num == 1) one++;
            if (num == 2) two++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < zero) {
                nums[i] = 0;
            } else if (i < one + zero) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
