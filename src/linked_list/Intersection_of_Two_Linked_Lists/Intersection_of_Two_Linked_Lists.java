package linked_list.Intersection_of_Two_Linked_Lists;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/17.
 * 160. Intersection of Two Linked Lists
 * getIntersectionNode1：根据链表长度来做的
 * getIntersectionNode2：不用知道链表长度，借助环的思想。因为两个指针走的距离一定一样长，此时就会相遇。所以两个指针都是两条链表都走到末尾的时候相等。
 * 如果没有交点：两个指针都走到链表的末尾，都等于null。
 * 如果有交点：正好走到交点处
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lengthA = 0, lengthB = 0;
        ListNode listA = headA, listB = headB;

        // 先计算出两个链表的长度
        for (ListNode tmpA = headA; tmpA != null; lengthA++, tmpA = tmpA.next) {
            ;
        }
        for (ListNode tmpB = headB; tmpB != null; lengthB++, tmpB = tmpB.next) {
            ;
        }

        // 长的先走一点，让两个表长度相等，然后两个表同时走
        if(lengthA >= lengthB)
        {
            for (int i = lengthA-lengthB; i>0; i--) {
                listA = listA.next;
            }
        }
        else
        {
            for (int i = lengthB-lengthA; i>0; i--) {
                listB = listB.next;
            }
        }

        // 判断对象是否相等，使用 == 即可
        while (listA!=listB && listA!=null && listB!=null)
        {
            listA = listA.next;
            listB = listB.next;
        }

        if(listA==null || listB==null) {
            return null;
        } else {
            return listA;
        }
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode tmpA = headA, tmpB = headB;

        while (tmpA!=tmpB)
        {
            tmpA = tmpA != null ? tmpA.next : headB;
            tmpB = tmpB != null ? tmpB.next : headA;
        }

        return tmpA;
    }

    public ListNode getIntersectionNode3(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2, null);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    private ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        if (loop1 == loop2) {
            return noLoop(head1,head2,loop1);
        } else {
            ListNode cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    private ListNode noLoop(ListNode head1, ListNode head2, ListNode end) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1, cur2 = head2;
        int n = 0;
        // 记录两个链表的长度
        while (cur1 != end) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != end) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        // cur1是长的，cur2是短的
        cur1 = n > 0 ? head1 : head2;
        cur2 = (cur1 == head1 ? head2 : head1);
        n = Math.abs(n);
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] algs)
    {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a2;
        b1.next = a3;
//        b2.next = b3;
//        b3.next = b2;
        Intersection_of_Two_Linked_Lists t = new Intersection_of_Two_Linked_Lists();
        // t.reverse(a2,a5);
        ListNode ans = t.getIntersectionNode3(a1,b1);
        if(ans == null) {
            System.out.println("null");
        } else {
            System.out.println(ans.val);
        }
    }
}
