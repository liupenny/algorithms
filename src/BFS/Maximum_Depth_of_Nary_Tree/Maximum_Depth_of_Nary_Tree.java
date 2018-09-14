package BFS.Maximum_Depth_of_Nary_Tree;

import tools.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/9/5.
 */

public class Maximum_Depth_of_Nary_Tree{
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        int max = 0;
        for (Node child: root.children) {
            int val = maxDepth(child);

            if(val > max) {
                max = val;
            }
        }
        return max+1;
    }

    public static void main(String[] args)
    {
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5,null));
        children2.add(new Node(6,null));
        Node head2 = new Node(3,children2);

        List<Node> children1 = new ArrayList<>();
        children1.add(head2);
        children1.add(new Node(2,null));
        children1.add(new Node(4,null));
        Node head1 = new Node(1,children1);

        Maximum_Depth_of_Nary_Tree t = new Maximum_Depth_of_Nary_Tree();
        System.out.println(t.maxDepth(head1));
    }
}