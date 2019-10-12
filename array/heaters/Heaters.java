package leetCode.array.heaters;

import java.util.Arrays;

/**
 * @Author Lunaticf
 * @Date 2019/10/12
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            // 如果没找到
            if (index < 0) {
                // 正确的插入位置
                index = -(index + 1);
                // can also use ~
//                index = ~index;
                // 如果房子左边没有heater 赋予MAX_VALUE
                int distLeft = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int distRight = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(distLeft, distRight));
            }

        }

        return result;
    }

    // two pointer
    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            // 找到离这座房子最近的heater
            while (j < heaters.length - 1 && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        return res;
    }
}
