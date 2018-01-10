package linked_list.Remove_Duplicates_from_Sorted_List;
import tools.*;

/**
 * Created by PennyLiu on 2017/10/9.
 * 83. Remove Duplicates from Sorted List
 * 非递归：deleteDuplicates1
 * 递归：deleteDuplicates2
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head;
        while (head!=null)
        {
            if (head.next.val == head.val)
                head.next = head.next.next;
            head = head.next;
        }
        return next;
    }

    public ListNode deleteDuplicates2(ListNode head) { //这个是要返回头部，所以先调用函数
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates2(head.next);
        return head.next.val==head.val?head.next:head;  // 从后往前不断比对
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(2);
        citations2.addNode(4);
        citations2.addNode(4);
        Remove_Duplicates_from_Sorted_List t = new Remove_Duplicates_from_Sorted_List();
        ListNode ans = t.deleteDuplicates2(citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
