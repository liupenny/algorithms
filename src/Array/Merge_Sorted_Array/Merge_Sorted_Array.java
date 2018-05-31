package Array.Merge_Sorted_Array;

/**
 * Created by PennyLiu on 2018/5/30.
 */
public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return;

        int[] res = new int[m+n];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if(index1 == m)
            {
                res[i] = nums2[index2++];
            }
            else if (index2 == n)
            {
                res[i] = nums1[index1++];
            }
            else if(nums1[index1] <= nums2[index2])
                res[i] = nums1[index1++];
            else
                res[i] = nums2[index2++];
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = res[i];
        }
        for (int i = 0; i < m+n; i++) {
            System.out.print(nums1[i]);
        }
    }

    // 从后往前比较的一个方法，不需要多余的时间和空间
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return;

        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0)
            nums1[index--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        while (j >= 0) //这里因为Nums1本来就是有序的，所以如果不符合第一个条件的话，有两种情况，一种是i < 0 ，这样前半部分由nums2填充；另一种是j<0，此时Nums1前面已经是有序的，就不用管了
            nums1[index--] = nums2[j--];
    }

    public static void main(String[] args) {
        Merge_Sorted_Array t = new Merge_Sorted_Array();
        int[] nums1 = {2,0}, nums2 = {1};
        int  m = 1, n = 1;
        t.merge(nums1,m,nums2,n);
    }
}
