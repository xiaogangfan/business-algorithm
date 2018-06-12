package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * Created by anduo on 17-3-12.
 * http://www.lintcode.com/zh-cn/problem/first-position-of-target/
 */
public class Question01FirstPositionOfTarget {
    public int binarySearch(int[] nums, int target) {
        if (nums == null && nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                end = mid;
            } else if (nums[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // return first position of target
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
