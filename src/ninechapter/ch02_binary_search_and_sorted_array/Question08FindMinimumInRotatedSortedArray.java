package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * http://www.lintcode.com/zh-cn/problem/find-minimum-in-rotated-sorted-array/
 * 假设一个旋转排序的数组其起始位置是未知的
 * （比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复的元素。
 * Created by anduo on 17-3-13.
 */
public class Question08FindMinimumInRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }


        int start = 0, end = nums.length - 1;
        int target = nums[end];

        // 4 5 6 7 0 1 2
        // find the first element <= target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
