package amazon;

import entity.ListNode;

// Reverse a singly linked list.

/**
 * 直接尾插法
 * Created by anduo on 17-3-13.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode now = null;
        while (head != null) {
            ListNode next = head.next;// 保存下一个节点
            head.next = now; // 断开原链表的头节点，并把next指向上一个节点
            now = head;
            head = next;
        }
        return now;
    }
}
