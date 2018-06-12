package ninechapter.ch02_binary_search_and_sorted_array;

import java.util.ArrayList;

/**
 * 恢复旋转排序数组
 * http://www.lintcode.com/zh-cn/problem/recover-rotated-sorted-array/
 * 给定一个旋转排序数组，在原地恢复其排序。
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * Created by anduo on 17-3-13.
 */
public class Question13RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for (int index = 0; index < nums.size() - 1; index++) {
            // 找到旋转点，也就是首次后边的数大于当前数
            if (nums.get(index) > nums.get(index + 1)) {
                reverse(nums, 0, index);// 翻转前半部分
                reverse(nums, index + 1, nums.size() - 1);// 翻转后半部分
                reverse(nums, 0, nums.size() - 1);// 整体再做一次翻转
                return;
            }
        }
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}
