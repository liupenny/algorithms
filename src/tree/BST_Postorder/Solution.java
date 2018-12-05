package tree.BST_Postorder;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/3
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] nums, int start, int end) {
        if (start == end) {
            return true;
        }
        int root = nums[end];
        int i = start;
        for (;i<end;i++) {
            if (nums[i] > root) {
                break;
            }
        }

        int j = i;
        for (;j<end;j++) {
            if (nums[j] < root) {
                return false;
            }
        }
        return verify(nums, start, i-1) && verify(nums, i, end - 1);
    }

    public static void main(String[] args) {
        int[] line = {5,7,6,9,11,10,8};
        Solution s = new Solution();
        boolean res = s.VerifySquenceOfBST(line);
        System.out.println(res);
    }
}
