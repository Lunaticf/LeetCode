package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/11/15
 */
public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        // nums递增 找到开始和结束的位置 target
        // 算法必须O(LogN)
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                // expand开始
                int p = mid;
                while (p >= 0 && nums[p] == target) {
                    p--;
                }

                int q = mid;
                while (q < nums.length && nums[q] == target) {
                    q++;
                }
                return new int[]{p + 1, q - 1};

            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
