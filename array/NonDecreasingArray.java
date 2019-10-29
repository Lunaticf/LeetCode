package leetCode.array;

/**
 * @Author Lunaticf
 * @Date 2019/10/29
 */
public class NonDecreasingArray {
    /**
     * 是否改变一个元素就能使得数组有序
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        // 有点类似贪心吧，我们先找到第一个乱序的元素，看能不能改掉他
        // 6 8 15 7 8 在改的时候一些trick，比如15可以改成7 但是7 比前面的8又小了
        // 所以要看是把7变成15 还是把15变成7
        // 这种情况就是把7变成15才行，判断的条件就是f[i]和f[i - 2]哪个大
        // 所以需要再往回看一下
        // 后面再碰到乱序就是false了
        for (int i = 0; i < nums.length - 1; i++) {
            // 定位到15
            if (nums[i] > nums[i + 1]) {
                if (i == 0) {
                    nums[i] = nums[i + 1];
                    break;
                }
                if (nums[i + 1] > nums[i - 1]) {
                    nums[i] = nums[i + 1];
                    break;
                } else {
                    nums[i + 1] = nums[i];
                    break;
                }
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new NonDecreasingArray().checkPossibility(new int[]{-1,4,2,3});
    }
}
