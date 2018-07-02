package tree.Convert_Sorted_Array_to_Binary_Search_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/7/2.
 */

public class Solution{
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);

        int len = nums.length;
        return build(nums, 0, len - 1);
    }

    public TreeNode build(int[] nums, int begin, int end)
    {
        if(begin > end)
            return null;

        int mid = begin + (end - begin)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, begin, mid - 1);
        root.right = build(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode node = s.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        node.printTree_format(node);
    }
}