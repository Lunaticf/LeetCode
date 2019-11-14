package leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/11/14
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        // 候选数不重复，找到所有候选数相加等于target
        // 一个候选数可以用无限次
        // 主要就是 dfs 回溯

        // no need to sort actually
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,0, 0, target, res, new ArrayList<>());

        return res;
    }

    private void dfs(int[] candidates, int sum, int pos, int target, List<List<Integer>> res, List<Integer> temp)    {
        if (sum > target || pos >= candidates.length) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // 继续加当前元素
        temp.add(candidates[pos]);
        dfs(candidates, sum + candidates[pos], pos, target, res, temp);

        temp.remove(temp.size() - 1);
        dfs(candidates, sum, pos + 1, target, res, temp);
    }
}
