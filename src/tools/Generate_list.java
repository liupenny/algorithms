package tools;/**
 * Created by PennyLiu on 2018/9/5.
 */

public class Generate_list{
    public static ListNode get_list(int[] nums){
        if(nums.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        for (int num:nums){
            ListNode tmp = new ListNode(num);
            ret.next = tmp;
            ret = ret.next;
        }
        return dummy.next;
    }
}