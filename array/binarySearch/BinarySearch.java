package leetCode.array.binarySearch;

/**
 * @Author Lunaticf
 * @Date 2019/10/22
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
