package linked_list.Copy_List_with_Random_Pointer;
import tools.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2017/10/18.
 * 138. Copy List with Random Pointer
 * 意思：要将原链表的关系赋值下来，所以重点在于怎么复制random这个关系。因为在遍历的时候，如果random指向后面的节点就无法指向random。
 * 如下图，新建的链表先放在旧链表的每个节点后面，而不是单独另起炉灶搞个新摊子，每个新节点都跟在原来节点屁股后面，
 * 这样新旧链表关系就非常密切，而不是割裂开来！等所有的新节点都放好后，就很容易把就链表的random指针复制到新链表，最后删除老节点即可！
 */
public class Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    public static void main(String[] algs)
    {
        RandomListNode a1 = new RandomListNode(2);
        RandomListNode a2 = new RandomListNode(4);
        RandomListNode a3 = new RandomListNode(5);
        RandomListNode a4 = new RandomListNode(9);
        RandomListNode a5 = new RandomListNode(19);
        RandomListNode a6 = new RandomListNode(21);
        RandomListNode a7 = new RandomListNode(33);
        a1.next = a2;
        a1.random = a3;
        a2.next = a3;
        a2.random = a4;
        a3.next = a4;
        a3.random = null;
        a4.next = a5;
        a4.random = a1;
        a5.next = a6;
        a5.random = a3;
        a6.next = a7;
        a6.random = a1;
        Copy_List_with_Random_Pointer t = new Copy_List_with_Random_Pointer();
        // t.reverse(a2,a5);
        RandomListNode ans = t.copyRandomList(a1);
        while (ans!=null)
        {
            System.out.println(ans.label);
            ans =ans.next;
        }
    }
}

