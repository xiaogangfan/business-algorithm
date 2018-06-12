package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * Created by anduo on 17-3-12.
 * http://www.lintcode.com/zh-cn/problem/search-for-a-range/
 * https://leetcode.com/problems/search-for-a-range
 * <h1>描述</h1>
 * <p>
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。<br/>
 * 如果目标值不在数组中，则返回[-1, -1]
 * </p>
 * 给出[5, 7, 7, 8, 8, 10]和目标值target=8,
 * 返回[3, 4]
 */
public class Question02SearchForARange {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }

        int[] bound = new int[2];
        int start, end, mid;

        // search for left bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {// miss value
            bound[0] = bound[1] = -1;
            return bound;
        }

        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        return bound;
    }
}
