package tree.Populating_Next_Right_Pointers_in_Each_Node;

import tools.TreeLinkNode;

/**
 * Created by PennyLiu on 2018/6/27.
 */

public class Solution{
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode cur = root, level = cur;
        while (cur != null) {
            level = cur;
            while (level != null) {
                if (level.left != null) {
                    level.left.next = level.right;
                }
                // 同一层跨子树间节点的指向
                if (level.right != null && level.next != null) {
                    level.right.next = level.next.left;
                }
                // 这一个节点的左右孩子都处理完了
                // 跳到旁边去
                level = level.next;
            }
            cur = cur.left;
        }
    }

    public static void main(String[] args)
    {
    
    }
}