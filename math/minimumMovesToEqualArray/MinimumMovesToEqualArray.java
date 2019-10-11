package leetCode.math.minimumMovesToEqualArray;

import java.util.stream.IntStream;

/**
 * @Author Lunaticf
 * @Date 2019/10/11
 */
public class MinimumMovesToEqualArray {
    public int minMoves(int[] nums) {
        return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
    }
}
