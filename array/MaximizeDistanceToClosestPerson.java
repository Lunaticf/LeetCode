package leetCode.array;

public class MaximizeDistanceToClosestPerson {
    /**
         一堆人坐着 和空座位
        坐到一个位子上跟别人的距离最大
        这个方法太麻烦了 就是找每个位置的左边距离和右边距离
        O(N)和O(N)
     */
    public int maxDistToClosest(int[] seats) {
        int[] res = new int[seats.length];

        int person = -1;

        // 前向来一遍
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (person != -1) {
                    res[i] = i - person;
                } else {
                    res[i] = Integer.MAX_VALUE;
                }
            } else {
                person = i;
            }
        }

        // 后面来一遍
        person = -1;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                if (person != -1) {
                    res[i] = Math.min(person - i, res[i]);
                }
            } else {
                person = i;
            }
        }

        int max = -1;
        for (int num : res) {
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     * 双指针很简洁
     * O(N)和O(1)✌️
     * 其实就是找两个1之间的距离 再除以2
     * @param seats
     * @return
     */
    public int maxDistToClosest1(int[] seats) {
        int last = -1;
        int res = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (last == -1) {
                    res = i;
                } else {
                    res = Math.max((i - last)/2, res);
                }
                last = i;
            }
        }

        return Math.max(res, seats.length - last - 1);
    }
}
