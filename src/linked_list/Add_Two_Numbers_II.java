import edu.princeton.cs.algs4.In;
import tools.ListNode;
import tools.Sort_List;

import java.util.Stack;

/**
 * Created by PennyLiu on 2017/10/4.
 * 445. Add Two Numbers II
 * 原本思路(addTwoNumbers1)：将链表中数字全部拿出来转换成str,再转换成int,相加以后再获取每个位置上的数字转换成一个单链表。
 * 但是这样会有输入字符串转换成int数字就超过int范围的情况。
 * 正确思路(addTwoNumbers2--75ms)：使用两个栈保存这两个数，依此取出从后往前算，但这样不符合follow up的想法，因为有reverse过程
 * 正确思路(addTwoNumbers3--57ms)：使用一个变量（也可以用栈），保存两个数从前往后每个位置相加的结果，然后对这些数从后往前处理，不符合follow up的想法，因为有reverse过程。
 * 正确思路(addTwoNumbers4--75ms)：使用一个栈，保存保存两个数从前往后每个位置相加的结果，然后对这些数从后往前处理，不符合follow up的想法，因为有reverse过程。
 * 正确思路(addTwoNumbers5--73ms)：还是采用3和4的思想，使用递归完成就会符合follow up的想法。
 */
public class Add_Two_Numbers_II {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        StringBuilder str_l1 = new StringBuilder();
        StringBuilder str_l2 = new StringBuilder();
        while (l1!=null)
        {
            str_l1.append(Integer.toString(l1.val));
            l1=l1.next;
        }
        while (l2!=null)
        {
            str_l2.append(Integer.toString(l2.val));
            l2 = l2.next;
        }
        String sl1 = str_l1.toString();
        String sl2 = str_l2.toString();
        int ll1 = Integer.valueOf(sl1).intValue();
        int ll2 = Integer.valueOf(sl2).intValue();
        int res = ll1 + ll2;
        int tmp;
        ListNode list = new ListNode(0);
        while (res!=0)
        {
            tmp = res % 10;
            res = res/10;
            list.val = tmp;
            ListNode head = new ListNode(res);
            head.next = list;
            list = head;
        }
        return list.val == 0 ? list.next : list;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1= new Stack<>();
        Stack<Integer> s2= new Stack<>();

        while (l1!=null)
        {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null)
        {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode end = new ListNode(0);
        int sum =0;
        while (!s1.empty() || !s2.empty())
        {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            end.val = sum%10;
            ListNode head = new ListNode(sum/10);   // 这里不能写0，因为是保存两个数加和的进位，后面再算进位数应该有的值时是使用最后的sum，会重新赋值的，这里用sum/10没有影响，但如果写0，那5+5这种的就不会保存了
            head.next = end;
            end = head;
            sum = sum/10;   //保存进位，下一次算的时候sum就直接加上了
        }
        return end.val==0?end.next:end;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        for (ListNode i = l1; i != null; i = i.next) n1++;
        for (ListNode i = l2; i != null; i = i.next) n2++;
        int sum = 0;
        ListNode tmp_res = null;
        while (n1>0 && n2>0)   // 这里是从前往后加，所以看那个数剩余的位数多就加哪个数对应的值
        {
            if(n1>=n2)   // 这两个>= 和 > 设计的比较巧妙
            {
                sum += l1.val;
                l1 = l1.next;
                n1--;
            }
            if(n2>n1)
            {
                sum += l2.val;
                l2 = l2.next;
                n2--;
            }
            tmp_res = addToFront(sum,tmp_res);
            sum = 0;
        }
        ListNode res = tmp_res;
        tmp_res = null;
        int count = 0;
        while (res!=null)
        {
            res.val += count;
            count = res.val/10;
            tmp_res = addToFront(res.val%10,tmp_res);
            res = res.next;
        }
        if(count!=0)
            tmp_res = addToFront(count,tmp_res);
        return tmp_res;
    }

    public ListNode addToFront(int val, ListNode last)
    {
        ListNode now = new ListNode(val);
        now.next = last;
        return now;
    }

    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        Stack<Integer> stack = new Stack<>();
        for (ListNode i = l1; i != null; i = i.next) n1++;
        for (ListNode i = l2; i != null; i = i.next) n2++;
        int sum = 0;
        while (n1>0 && n2>0)   // 这里是从前往后加，所以看那个数剩余的位数多就加哪个数对应的值
        {
            if(n1>=n2)   // 这两个>= 和 > 设计的比较巧妙
            {
                sum += l1.val;
                l1 = l1.next;
                n1--;
            }
            if(n2>n1)
            {
                sum += l2.val;
                l2 = l2.next;
                n2--;
            }
            stack.push(sum);
            sum = 0;
        }
        ListNode res = null;
        int count = 0;
        sum = 0;
        while (!stack.empty())
        {
            count = stack.pop() + sum;
            sum = count/10;
            res = addToFront(count%10,res);
        }
        if(sum!=0)
            res = addToFront(sum,res);
        return res;
    }



    public int carry = 0;
    public ListNode addTwoNumbers5(ListNode l1, ListNode l2)
    {
        int len1 = getlength(l1), len2 = getlength(l2);
        ListNode ans = new ListNode(1);
        ans.next = len1>len2?add(l1,l2,len1-len2):add(l2,l1,len2-len1);
        return carry==1?ans:ans.next;
    }

    public int getlength(ListNode l)
    {
        int n=0;
        for (ListNode i = l; i != null; i = i.next) n++;
        return n;
    }

    public ListNode add(ListNode l1, ListNode l2, int dif)  // 递归过程，使用全局变量carry记录是否有进位
    {
        if(l2 == null) return null;
        ListNode tmp = new ListNode(l1.val); // 因为传进来的参数长度上l1 > l2，所以在这一步构造当前节点就先加上l1.val
        if(dif>0)
            tmp.next = add(l1.next,l2,dif-1);
        else  // dif=0代表两个位都要相加
        {
            tmp.val += l2.val;  // 构造的当前节点需要加上l2.val
            tmp.next = add(l1.next,l2.next,dif);  // 继续向下运算
        }
        tmp.val += carry;  //在这里的时候是每一步运算完要往头部去清算进位的过程。
        carry = tmp.val/10;
        tmp.val %= 10;
        return tmp;
    }


    public static void main(String[] algs)
    {
        Add_Two_Numbers_II t = new Add_Two_Numbers_II();
        Sort_List.Linklist citations1 = new Sort_List.Linklist();
        citations1.addFirstNode(5);
        citations1.addNode(8);
        citations1.addNode(4);
        citations1.addNode(3);
        citations1.addNode(7);
        Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(6);
        citations2.addNode(4);
        citations2.addNode(5);
        ListNode ans = t.addTwoNumbers5(citations1.first,citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
