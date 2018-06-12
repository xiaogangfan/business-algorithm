package ninechapter.ch04_permutation_and_subset;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
// 排列问题 时间复杂度 n!


/**
 * Created by anduo on 17-3-14.
 */
public class Question03Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result,
                     ArrayList<Integer> items,
                     int[] nums) {
        if (items.size() == nums.length) {
            result.add(new ArrayList<>(items));
        }

        for (int i = 0; i < nums.length; i++) {
            if (items.contains(nums[i])) {// 判断这个数是不是已经在排列中了
                continue;
            }
            items.add(nums[i]);
            dfs(result, items, nums);
            items.remove(items.size() - 1);
        }
    }

}
