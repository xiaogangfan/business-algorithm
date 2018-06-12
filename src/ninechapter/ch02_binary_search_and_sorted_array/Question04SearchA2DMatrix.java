package ninechapter.ch02_binary_search_and_sorted_array;
/**
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 * <p>
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3,返回 true
 */

/**
 * Created by anduo on 17-3-13.
 */
public class Question04SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分
        if (matrix == null
                || matrix.length == 0
                || matrix[0] == null
                || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row;// 需要找的目标行
        // 先找到行
        int start = 0;
        int end = rows - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int v = matrix[mid][0];
            if (v == target) {
                return true;
            } else if (v > target) {// 说明一定在mid行的上班部分
                end = mid;
            } else {// 在mid行的下半部分
                start = mid;
            }
        }
        if (matrix[end][0] <= target) {// 如果在上半部分
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }

        // 找列
        start = 0;
        end = cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int v = matrix[row][mid];
            if (v == target) {
                return true;
            } else if (v > target) {// 说明一定在mid列的前半部分
                end = mid;
            } else {// 在mid列的后部分
                start = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}
