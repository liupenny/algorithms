package linked_list.Add_Two_Numbers;

import tools.*;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/17.
 *
 * 思路：要有进位、求和；有可能某个链表只有一个数字还要判断数位
 */
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;   //进位、求和
        ListNode end = new ListNode(0), ans = end;
        while (l1!= null || l2!=null || carry!=0)
        {
            sum = ( l1==null?0:l1.val ) + ( l2==null?0:l2.val ) + carry;  //因为可能会有1+9999的情况，所以在这里每次都对两个链表进行判断
            carry = sum/10;
            sum = sum%10;
            ListNode tmp = new ListNode(sum);
            ans.next = tmp;
            ans = tmp;
            l1 = (l1==null?l1:l1.next);
            l2 = (l2==null?l2:l2.next);
        }
        return end.next;
    }

    public static void main(String[] algs)
    {
        Add_Two_Numbers t = new Add_Two_Numbers();
        tools.Sort_List.Linklist citations1 = new Sort_List.Linklist();
        citations1.addFirstNode(2);
        //citations1.addNode(8);
        citations1.addNode(4);
        //citations1.addNode(3);
        Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(5);
        citations2.addNode(6);
        citations2.addNode(4);
        //citations2.addNode(4);
        //citations2.addNode(5);
        ListNode ans = t.addTwoNumbers(citations1.first,citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
