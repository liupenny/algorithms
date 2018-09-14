package tools;

import java.util.List;

/**
 * Created by PennyLiu on 2018/9/5.
 */

public class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
}