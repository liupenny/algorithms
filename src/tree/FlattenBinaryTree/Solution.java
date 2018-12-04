package tree.FlattenBinaryTree;

import tools.TreeNode;

import java.util.Arrays;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/4
 */
public class Solution {
    TreeNode leftHead = null;
    TreeNode rightHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        //递归调用叶子节点的左右节点返回null
        if(pRootOfTree==null) {
            return null;
        }
        //第一次运行时，它会使最左边叶子节点为链表第一个节点
        Convert(pRootOfTree.left);
        if(rightHead==null){
            leftHead= rightHead = pRootOfTree;
        }else{
            //把根节点插入到双向链表右边，rightHead向后移动
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        //把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
        Convert(pRootOfTree.right);
        //返回左边头结点
        return leftHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[10,6,14,4,8,12,16]");
        s.Convert(p);
        String a = "aaa";
        char[] aa= {'1','2','3'};
        Arrays.sort(aa);
    }
}
