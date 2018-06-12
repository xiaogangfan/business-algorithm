package ninechapter.ch05_linked_list;

import entity.ListNode;
// https://leetcode.com/problems/linked-list-cycle
// 判断一个链表是不是有环
// 快慢指针就可以了

/**
 * Created by anduo on 17-3-14.
 */
public class Question06LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {// fast追上slow
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next) {
            // 另一个指针开始从头开始走，slow和head相遇的是否就是环的起点
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

}
