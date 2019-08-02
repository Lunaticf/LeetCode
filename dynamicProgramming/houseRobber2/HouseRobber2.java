package LeetCode.dynamicProgramming.houseRobber2;

public class HouseRobber2 {
    private int robberHouses(int[] nums, int left, int right) {
        int pprev = 0;
        int prev = 0;
        for (int i = left; i <= right; i++) {
            int temp = prev;
            prev = Math.max(prev, pprev + nums[i]);
            pprev = temp;
        }
        return prev;
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robberHouses(nums, 0, nums.length - 2), robberHouses(nums, 1, nums.length - 1));
    }

}
