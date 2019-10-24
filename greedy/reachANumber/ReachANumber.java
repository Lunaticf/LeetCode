package leetCode.greedy.reachANumber;

/**
 * @Author Lunaticf
 * @Date 2019/10/24
 */
public class ReachANumber {
    public int reachNumber(int target) {
        target = Math.abs(target);

        int sum = 0;
        int count = 0;
        while (sum < target) {
            count += 1;
            sum += count;
        }

        while ((sum - target) % 2 != 0) {
            count += 1;
            sum += count;

        }


        return count;
    }
}
