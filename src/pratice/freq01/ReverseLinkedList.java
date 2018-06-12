package pratice.freq01;

import entity.ListNode;

/**
 * Created by anduo on 17-3-12.
 * 链表的基本形式是: 1->2->3->null,反转需要变为3->2->	1->null。这里要注意:
 * 访问某个节点curt.next时,要检验curt是否为null。
 * 要把反转后的最后一个节点(即反转前的第一个节点)指向null。
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode root) {
        ListNode prev = null;
        while (root != null) {
            ListNode next = root.next;// 暂存next指针，方便原链表往后遍历
            root.next = prev;// 反向插入
            prev = root;// 头插法
            root = next;// 遍历下一个节点
        }
        return prev;
    }
}
