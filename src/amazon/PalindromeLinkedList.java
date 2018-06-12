package amazon;

import entity.ListNode;
/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 判断链表是不是回文
 * 做法，快慢指针就可以了。
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Created by anduo on 17-3-13.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head.next;

        // 找到中间的节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {// 奇数的情况
            slow = slow.next;
        }

        // 翻转后边的节点
        ListNode reverse = reverse(slow);
        while (head != null && reverse != null && head.val == reverse.val) {
            head = head.next;
            reverse = reverse.next;
        }
        return reverse == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode now = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = now;
            now = head;
            head = next;
        }
        return now;
    }
}
