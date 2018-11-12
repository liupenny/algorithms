package linked_list;

import tools.ListNode;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: algorithms
 * @Description: 单链表的插入，删除，查找
 * @date 2018/10/7
 */
public class BasicOperation {
    public ListNode head = null;

    public static ListNode createNode(int val){
        return new ListNode(val,null);
    }

    public void printAll() {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
    /**
    * @Description: 以下是插入操作：在头部插入，在节点后，节点前插入（值，节点）
    * @Param: [val]
    * @return: void
    * @Author: PennyLiu
    * @Date: 2018/10/7
    */
    public void insertToHead(int val){
        ListNode node = new ListNode(val,null);
        insertToHead(node);
    }

    public void insertToHead(ListNode node){
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertAfter(ListNode p , int val){
        ListNode node = new ListNode(val, null);
        insertAfter(p,node);
    }

    public void insertAfter(ListNode p , ListNode node){
        if (p == null) {
            return;
        }

        node.next = p.next;
        p.next = node;
    }

    public void insertBefore(ListNode p , int val){
        ListNode node = new ListNode(val, null);
        insertBefore(p,node);
    }

    public void insertBefore(ListNode p , ListNode node){
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(node);
        }
    }

    /**
    * @Description:  以下是删除操作：根据（值，节点）删除
    * @Param:
    * @return:
    * @Author: PennyLiu
    * @Date: 2018/10/7
    */
    public void deleteByNode(ListNode p){
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.next;
        }

        ListNode q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }


    public void deleteByValue(int val){
        if (head == null) {
            return;
        }

        ListNode p = head;
        ListNode q = null;
        while (p != null && p.val != val) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }
        // 头节点的值是val
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

    }

    /**
     * @Description:  以下是查找操作：根据（值，索引）查找
     * @Param:
     * @return:
     * @Author: PennyLiu
     * @Date: 2018/10/7
     */
    public ListNode findByValue(int val){
        ListNode p = head;
        while (p != null && p.val != val) {
            p = p.next;
        }
        return p;
    }

    public ListNode findByIndex(int index){
        ListNode p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    public static void main(String[] args) {
        BasicOperation a = new BasicOperation();
        a.head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.head.next = b;
        b.next = c;
        a.deleteByValue(3);
    }
}
