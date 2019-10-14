package leetCode.array.relativeRanks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lunaticf
 * @Date 2019/10/14
 */
public class RelativeRanks {

    /**
     * 用map来保存数字对应的索引就可以了 readable is best
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 保存索引
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        Arrays.sort(nums);

        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1)
                res[map.get(nums[i])] = "Gold Medal";
            else if (i == nums.length-2)
                res[map.get(nums[i])] = "Silver Medal";
            else if (i == nums.length-3)
                res[map.get(nums[i])] = "Bronze Medal";
            else
                res[map.get(nums[i])] = (nums.length - i) + "";
        }
        return res;
    }


    class IndexNum implements Comparable<IndexNum> {
        int index;
        int num;

        @Override
        public int compareTo(IndexNum other) {
            return other.num - num;
        }
    }

    public String[] findRelativeRanks1(int[] nums) {
        // 对每个位置的元素返回该元素自己的排名
        // 用一个结构体包裹num和index 再排序


        IndexNum[] indexNums = new IndexNum[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexNums[i] = new IndexNum();
            indexNums[i].index = i;
            indexNums[i].num = nums[i];
        }

        Arrays.sort(indexNums);

        String[] res = new String[nums.length];
        for (int i = 0; i < indexNums.length; i++) {
            if (i == 0) {
                res[indexNums[i].index] = "Gold Medal";
            } else if (i == 1) {
                res[indexNums[i].index] = "Silver Medal";
            } else if (i == 2) {
                res[indexNums[i].index] = "Bronze Medal";
            } else {
                res[indexNums[i].index] = i + 1 + "";
            }

        }
        return res;
    }
}

