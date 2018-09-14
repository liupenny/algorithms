package linked_list.Palindrome_Linked_List;
import tools.*;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/15.
 * 234. Palindrome Linked List
 * 思路：使用O（n）的时间 和 O（1）的空间。因此，如果这时将链表整个翻转再去对比需要O（n）的空间。
 * 因此，考虑先用快慢指针找到中间，再将后半部分直接翻转。再从head开始和后半部分依次作比较。
 */
public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next !=null)  //这个只有这么判断才会让slow正好在偶数个数的时候处于中间，如果是（fast!=null || fast.next !=null）会多走一步
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverseList(slow.next);
        slow = slow.next;
        while (slow!=null && head.val==slow.val)  //这一步很妙，用slow.next ！= null做条件判断。可以省略 奇偶 判断，偶数正好从中间开始，奇数就正好忽略了中间那个
        {
            head = head.next;
            slow = slow.next;
        }
        if(slow == null) {
            return true;
        } else {
            return false;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode tail = null;  //只是声明并没有新建，所以不会有额外的空间复杂度
        while (head!=null)
        {
            ListNode tmp = head.next;  //如果令tmp = head,再改变tmp.next的话，此时head.next也会改变，所以先保存head.next去改变head
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(2);
        citations2.addNode(1);
        //citations2.addNode(1);
        Palindrome_Linked_List t = new Palindrome_Linked_List();
        boolean ans = t.isPalindrome(citations2.first);
        System.out.println(ans);
    }
}
