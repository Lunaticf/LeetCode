package leetCode.hashTable.distributeCandies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lunaticf
 * @Date 2019/10/17
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        // 必须要姐姐和弟弟一样多，然后让姐姐的种类最多
        // candies >= 2 并且为偶数
        // 那就是尽可能把有2个以上的糖果分给弟弟
        Arrays.sort(candies);
        int kind = 1;
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] != candies[i - 1]) {
                kind++;
            }
        }
        return kind > candies.length / 2 ? candies.length / 2 : kind;
    }

    /**
     * 或者用set计算个数
     * @param candies
     * @return
     */
    public int distributeCandies1(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candie : candies) {
            set.add(candie);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    /**
     * 暴力枚举
     * @param candies
     * @return
     */
    int max_kind = 0;
    public int distributeCandies2(int[] candies) {
        permute(candies, 0);
        return max_kind;
    }

    public void permute(int[] nums, int l) {
        // 检测这个序列可以拿到的最大的kind
        if (l == nums.length - 1) {
            HashSet < Integer > set = new HashSet < > ();
            for (int i = 0; i < nums.length / 2; i++) {
                set.add(nums[i]);
            }
            max_kind = Math.max(max_kind, set.size());
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            permute(nums, l + 1);
            swap(nums, i, l);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }
}
