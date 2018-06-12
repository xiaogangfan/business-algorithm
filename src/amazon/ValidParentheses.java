package amazon;

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


import java.util.Stack;

/**
 * 括号匹配问题，用一个栈来解决
 * leetcode20 -> https://leetcode.com/problems/valid-parentheses
 * Created by anduo on 17-3-13.
 */
public class ValidParentheses {
    public boolean isValid(String input) {
        if (input == null || input.length() < 2) return false;
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) return false;
                if (ch == ')' && stack.pop() != '(') return false;
                if (ch == ']' && stack.pop() != '[') return false;
                if (ch == '}' && stack.pop() != '{') return false;
            }
        }
        return stack.empty();
    }
}
