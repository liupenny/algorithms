package BFS.Nary_Tree_Level_Order_Traversal;


import tools.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/9/5.
 */

public class Nary_Tree_Level_Order_Traversal{
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        List<Integer> level = new ArrayList<>();
        level.add(root.val);
        ans.add(level);
        Queue<Node> levelNode = new LinkedList<>();
        for (Node point:root.children) {
            levelNode.add(point);
        }

        while (!levelNode.isEmpty()){
            int size = levelNode.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node tmp = levelNode.poll();
                levelList.add(tmp.val);
                if(tmp.children != null){
                    for (Node t: tmp.children) {
                        levelNode.add(t);
                    }
                }
            }
            ans.add(levelList);
        }

        return ans;
    }

    public static void main(String[] args)
    {
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5,null));
        children2.add(new Node(6,null));
        Node head2 = new Node(3,children2);

        List<Node> children1 = new ArrayList<>();
        children1.add(head2);
        //children1.add(new Node(2,null));
        //children1.add(new Node(4,null));
        Node head1 = new Node(1,children1);

        Nary_Tree_Level_Order_Traversal t = new Nary_Tree_Level_Order_Traversal();
        System.out.println(t.levelOrder(null));
    }
}