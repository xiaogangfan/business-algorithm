package amazon;
// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?

/**
 * 旋转图像
 * <p>
 * 1 2 3                      1 4 7                     7 4 1
 * 4 5 6  ----正对角线翻转--->  2 5 8  ----竖对角线翻转---> 8 5 2
 * 7 8 9                      3 6 9                     9 6 3
 * Created by anduo on 17-3-13.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 正对角线翻转
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                // swap
                // a ^= b; b ^= a; a ^= b;
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }

        // 竖对角线翻转
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                matrix[i][j] ^= matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][cols - j - 1];
            }
        }
    }
}
