package tools;


/**
 * Created by PennyLiu on 2017/9/27.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode node){
        val = x;
        next = node;
    }

    public int getVal(){
        return val;
    }

}
