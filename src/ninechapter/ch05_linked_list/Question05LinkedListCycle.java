package ninechapter.ch05_linked_list;

import entity.ListNode;
// https://leetcode.com/problems/linked-list-cycle
// 判断一个链表是不是有环
// 快慢指针就可以了

/**
 * Created by anduo on 17-3-14.
 */
public class Question05LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head.next;
        do {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        return true;
    }

}
