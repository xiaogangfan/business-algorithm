package ninechapter.ch04_permutation_and_subset;
// https://leetcode.com/problems/subsets/#/description
// 子集
// 给定一个含不同整数的集合，返回其所有的子集
// http://www.lintcode.com/zh-cn/problem/subsets/
// 如果 S = [1,2,3]，有如下的解：
//[
//    [3],
//    [1],
//    [2],
//    [1,2,3],
//    [1,3],
//    [2,3],
//    [1,2],
//    []
//]

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anduo on 17-3-14.
 */
public class Question02SubSetsII {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);// 先排序是为了后边避免元素重复比如{1,2}和{2,1}

        dfs(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> items,
                     int[] nums,
                     int pos) {
        result.add(new ArrayList<>(items));

        for (int i = pos; i < nums.length; i++) {
            if (i > 0 && i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            items.add(nums[i]);
            dfs(result, items, nums, i + 1);
            // *回溯* 移除最后添加一个元素，相当于返回上一层的集合
            items.remove(items.size() - 1);
        }
    }

}
