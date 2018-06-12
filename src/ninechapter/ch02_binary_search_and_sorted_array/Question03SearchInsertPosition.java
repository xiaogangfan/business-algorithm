package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * Created by anduo on 17-3-12.
 * https://leetcode.com/problems/search-insert-position
 * http://www.lintcode.com/zh-cn/problem/search-insert-position/
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。
 * 如果没有，返回到它将会被按顺序插入的位置。
 * 你可以假设在数组中无重复元素。
 */
public class Question03SearchInsertPosition {
    public int searchInsertPosition(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (target <= A[0]) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
