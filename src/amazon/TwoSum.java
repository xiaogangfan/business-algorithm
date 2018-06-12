package amazon;

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:
// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

import java.util.HashMap;

/**
 * Created by anduo on 17-3-13.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // 有一个map记录前面的值在数组中的位置，这样遍历的是否就可以找到target - nums[i] 的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {// 找到答案了
                return new int[]{map.get(key) + 1, i + 1};
            }
            map.put(key, i);
        }

        return new int[]{-1, -1};

    }
}
