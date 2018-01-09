package linked_list.Insertion_sort_list;

import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/9.
 * leetcode:147. Insertion Sort List
 */
public class Insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode now = head;
        ListNode next = head;
        ListNode helper = new ListNode(0);
        ListNode pre = helper;

        while(now != null)
        {
            next = now.next;
            while(pre.next != null && now.val >= pre.next.val)
                pre = pre.next;

            now.next = pre.next;
            pre.next = now;
            pre = helper;
            now = next;
        }
        return helper.next;
    }
}
