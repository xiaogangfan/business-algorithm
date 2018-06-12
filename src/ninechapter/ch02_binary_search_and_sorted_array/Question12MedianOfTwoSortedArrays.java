package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * http://www.lintcode.com/zh-cn/problem/median-of-two-sorted-arrays/
 * 两个排序数组的中位数
 * 两个排序的数组A和B分别含有m和n个数，找到两个排序数组的中位数，要求时间复杂度应为O(log (m+n))。
 * -----------------------------------------------
 * 给出数组
 * A = [1,2,3,4,5,6]
 * B = [2,3,4,5]，
 * 中位数3.5
 * -----------------------
 * 给出数组
 * A = [1,2,3]
 * B = [4,5]，
 * 中位数 3
 * Created by anduo on 17-3-13.
 */
public class Question12MedianOfTwoSortedArrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        int num1 = findKth(A, 0, B, 0, len / 2);
        int num2 = findKth(A, 0, B, 0, len / 2 + 1);
        return (num1 + num2) / 2.0;
    }

    // find kth number of two sorted arra
    // 从两个数组中找出第k大的数
    public int findKth(int[] A, int A_start,
                       int[] B, int B_start,
                       int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }

        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        // 取A、B的中位数
        int A_median_index = A_start + k / 2 - 1;
        int B_median_index = B_start + k / 2 - 1;
        int A_key = A_median_index < A.length ? A[A_median_index] : Integer.MAX_VALUE;
        int B_key = B_median_index < B.length ? B[B_median_index] : Integer.MAX_VALUE;
        if (A_key < B_key) {
            // A的中位数小于B的中位数，就到A的后边再去找 与 B的减半部分 找相等的值
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            //A的中位数大于B的中位数，就到A的前半部分找 与 B的后半部分找
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }

    }
}
