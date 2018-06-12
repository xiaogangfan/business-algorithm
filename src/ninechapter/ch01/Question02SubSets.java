package ninechapter.ch01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anduo on 17-3-13.
 */
public class Question02SubSets {

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();

        // 先把集合排序 nlog(n)
        Arrays.sort(nums);

        dfs(result, list, nums, 0);
        return result;
    }

    /**
     * 构造子集合
     *
     * @param result
     * @param list
     * @param num
     * @param pos
     */
    private void dfs(ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> list,
                     int[] num,
                     int pos) {
        result.add(new ArrayList<>(list));
        // 从nums的pos位置开始，先把自己加进去，然后把自己的子集合加进去
        for (int i = pos; i < num.length; i++) {
            list.add(num[i]);
            dfs(result, list, num, i + 1);
            list.remove(list.size() - 1);// 需要移除最后一个元素
        }
    }


    // 非递归解法
    public ArrayList<ArrayList<Integer>> subsetsNoRecursion(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]

        int total = 1 << n;// 一共有2^n个子集合
        for (int i = 0; i < total; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}
