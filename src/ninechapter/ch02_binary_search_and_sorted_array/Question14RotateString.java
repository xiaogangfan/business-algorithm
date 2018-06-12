package ninechapter.ch02_binary_search_and_sorted_array;

/**
 * 旋转字符串
 * http://www.lintcode.com/zh-cn/problem/rotate-string/
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * --------
 * 对于字符串 "abcdefg".
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * -------
 * Created by anduo on 17-3-13.
 */
public class Question14RotateString {
    /**
     * @param str:    an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0)
            return;
        offset = offset % str.length;

        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }

}
