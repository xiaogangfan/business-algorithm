package ninechapter.ch01;

/**
 * Created by anduo on 17-3-13.
 */
public class Question01StrStr {

    // 模式匹配算法总结 http://dsqiu.iteye.com/blog/1700312
    // 需要知道概念和原理
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int i, j;

        // source最多比较的字符个数应该是 len(source) - len(target)
        int range = source.length() - target.length();
        for (i = 0; i < range; i++) {
            for (j = 0; j < target.length(); j++) {
                // 如果存在滑动窗口内的对应位置元素不相同，就将source的字符往下移动
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {// 全部匹配完成
                return i;
            }
        }

        return -1;
    }
}
