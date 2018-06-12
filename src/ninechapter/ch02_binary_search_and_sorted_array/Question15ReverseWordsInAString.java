package ninechapter.ch02_binary_search_and_sorted_array;

import java.util.Arrays;

/**
 * 翻转字符串
 * http://www.lintcode.com/zh-cn/problem/reverse-words-in-a-string/
 * 给定一个字符串，逐个翻转字符串中的每个单词
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * -----
 * 单词的构成：无空格字母构成一个单词
 * 输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 * 如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 * ----
 * Created by anduo on 17-3-13.
 */
public class Question15ReverseWordsInAString {
    private static final int BLANK_CHAR_CODE = 32;

    /**
     * @param s : A string
     * @return : A string
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        // 先去掉多余的空格
        int n = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == BLANK_CHAR_CODE) {
                while (i + 1 < chars.length && chars[i + 1] == BLANK_CHAR_CODE) {
                    i++;// skip next all blank char
                }
            }
            if (i == chars.length - 1 && chars[i] == BLANK_CHAR_CODE) continue;
            // copy
            chars[n++] = chars[i];
        }
        chars = Arrays.copyOfRange(chars, 0, n);

        // 全部翻转
        reverse(chars, 0, n - 1);
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 32) {// 碰到空格，就翻转前面的
                reverse(chars, start, i - 1);
                start = i + 1;
            }
            if (i + 1 == n) {// 到最后了，一定要翻转一把
                reverse(chars, start, i);
            }
        }
        return String.valueOf(chars);
    }

    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue   "));
    }
}
