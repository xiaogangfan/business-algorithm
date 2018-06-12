package amazon;

import entity.ListNode;
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * leetcode 2 -> https://leetcode.com/problems/add-two-numbers
 * 扩展:https://leetcode.com/problems/add-two-numbers-ii/
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);// 哨兵节点，用来做返回值的头结点使用。
        ListNode tail = dummy; // 用一个tail指针来操作dummy的下一个节点
        int sum = 0; // 每次遍历两个链表的和
        while (l1 != null || l2 != null) {
            sum /= 10; // 每次进来之后都取上次sum的十位
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(sum % 10);// 尾插新节点，新节点的值为sum的个位数，十位进一
            tail = tail.next;
        }
        if (sum / 10 == 1) {
            tail.next = new ListNode(1);
        }

        return dummy.next;
    }
}
