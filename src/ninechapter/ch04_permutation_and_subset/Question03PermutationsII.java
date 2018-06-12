package ninechapter.ch04_permutation_and_subset;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
// 排列问题 时间复杂度 n!


/**
 * Created by anduo on 17-3-14.
 */
public class Question03PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void dfs(List<List<Integer>> result,
                     ArrayList<Integer> items,
                     int[] nums, boolean[] visited) {
        if (items.size() == nums.length) {
            result.add(new ArrayList<>(items));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] ||
                    i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            items.add(nums[i]);
            dfs(result, items, nums, visited);
            // 回溯->递归之后还原
            items.remove(items.size() - 1);
            visited[i] = false;
        }
    }

}
