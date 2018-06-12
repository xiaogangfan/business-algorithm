package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * Created by anduo on 17-3-12.
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 * http://www.lintcode.com/zh-cn/problem/search-in-rotated-sorted-array-ii/
 * 跟进“搜索旋转排序数组”，假如有重复元素又将如何？
 * 是否会影响运行时间复杂度？
 * 如何影响？
 * 为何会影响？
 * 写出一个函数判断给定的目标值是否出现在数组中。
 */
public class Question11SearchInRotatedSortedArrayII {
    // 这个问题在面试中不会让实现完整程序
    // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
    // 在这种情况下是无法使用二分法的，复杂度是O(n)
    // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
    // 如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    // 反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
