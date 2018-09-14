package linked_list.Remove_Duplicates_from_Sorted_List_II;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/10.
 * 82. Remove Duplicates from Sorted List II
 * 非递归：deleteDuplicates1
 * 递归：deleteDuplicates2
 * 递归的思路：
 * if current node is not unique, return deleteDuplicates with head.next.
 * If current node is unique, link it to the result of next list made by recursive call. Any improvement?
 */
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next ==null) {
            return head;
        }
        ListNode newhead = new ListNode(0), pre=newhead,cur=head;
        newhead.next = head;
        while (cur!=null)
        {
            while (cur.next != null && cur.val == cur.next.val)  //重点在这里，当cur往前走的时候，pre并没有往前走，所以pre一直保留着上一个位置
            {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return newhead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null) {
            return head;
        }
        if(head!=null && head.val==head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        }
        else {
            head.next = deleteDuplicates2(head.next);
        }
        return head;
    }


    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(2);
        citations2.addNode(4);
        citations2.addNode(4);
        Remove_Duplicates_from_Sorted_List_II t = new Remove_Duplicates_from_Sorted_List_II();
        ListNode ans = t.deleteDuplicates2(citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
