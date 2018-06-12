package ninechapter.ch02_binary_search_and_sorted_array;
/**
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。
 * 每一列的整数从上到下是排序的。
 * 在每一行或每一列中没有重复的整数。
 * <p>
 * [
 * [1, 3, 5, 7],
 * [2, 4, 7, 8],
 * [3, 5, 9, 10]
 * ]
 * target = 3,返回 2
 */

/**
 * Created by anduo on 17-3-13.
 */
public class Question05SearchA2DMatrixII {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0] == null
                || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int x = rows - 1;
        int y = 0;
        int count = 0;
        while (x >= 0 && y < cols) {
            if (matrix[x][y] == target) {// 如果找到相应的元素
                count++;
                x--;
                y++;
                // 行列都移动
            } else if (matrix[x][y] < target) {
                y++;// 在下一列
            } else {
                x--;//在上一行
            }
        }

        return count;
    }
}
