package LeetCode.array.maxConsecutiveOnes;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        return count > res ? count : res;
    }

    // 评论中一个有意思的解法
    public int findMaxConsecutiveOnes1(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            count *= num;
            count += num;
            res = count > res ? count : res;
        }
        return res;
    }
}
