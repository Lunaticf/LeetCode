package leetCode.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Lunaticf
 * @Date 2019/11/9
 */
public class PowerfulInteger {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> res = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                res.add(i + j);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList(res);
    }
}
