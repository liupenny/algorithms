package linked_list;

import tools.ListNode;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: algorithms
 * @Description: 1) 单链表反转
 *  * 2) 链表中环的检测
 *  * 3) 两个有序的链表合并
 *  * 4) 删除链表倒数第n个结点
 *  * 5) 求链表的中间结点
 * @date 2018/10/7
 */
public class LinkedListAlgo {
    // 单链表反转
    public static ListNode reverse(ListNode list) {
        ListNode dummyHead = null;
        ListNode cur = list;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = dummyHead;
            dummyHead = cur;
            cur = next;
        }
        return cur;
    }

    // 检测环
    public static boolean checkCircle(ListNode list) {
        if (list == null) {
            return false;
        }

        ListNode fast = list;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 有序链表合并
    public static ListNode mergeSortedLists(ListNode la, ListNode lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }

        ListNode p = la;
        ListNode q = lb;
        ListNode head;
        if (p.val < q.val) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        ListNode r = head;

        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    // 删除倒数第K个结点
    public static ListNode deleteLastKth(ListNode list, int k) {
        ListNode fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        ListNode slow = list;
        ListNode prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static ListNode findMiddleNode(ListNode list) {
        if (list == null) {
            return null;
        }

        ListNode fast = list;
        ListNode slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
