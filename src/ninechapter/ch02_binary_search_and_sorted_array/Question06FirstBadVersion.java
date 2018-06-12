package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * 代码库的版本号是从 1 到 n 的整数。
 * 某一天，有人提交了错误版本的代码，因此造成自身及之后版本的代码在单元测试中均出错。
 * 请找出第一个错误的版本号。
 * 你可以通过isBadVersion的接口来判断版本号version是否在单元测试中出错，
 * 具体接口详情和调用方法请见代码的注释部分。
 * 样例
 * 给出 n=5
 * 调用isBadVersion(3)，得到false
 * 调用isBadVersion(5)，得到true
 * 调用isBadVersion(4)，得到true
 * 此时我们可以断定4是第一个错误的版本号
 * Created by anduo on 17-3-13.
 */
public class Question06FirstBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 0;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }

    static class SVNRepo {
        public static boolean isBadVersion(int n) {
            return true;
        }
    }
}
