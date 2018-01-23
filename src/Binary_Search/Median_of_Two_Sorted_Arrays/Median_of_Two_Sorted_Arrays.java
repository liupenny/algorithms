package Binary_Search.Median_of_Two_Sorted_Arrays;

/**
 * Created by PennyLiu on 2018/1/17.
 * findMedianSortedArrays：根据左老师思路转换，没有完全明白
 * findMedianSortedArrays1：利用归并排序
 */
public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0)   //前两种情况直接判断，使用数组角标，奇数：（len - 1）/2，偶数：[（len-1）/2 + len/2]/2.0(有2.0就返回浮点类型)
        {
            return nums2.length%2==0 ? (nums2[(nums2.length-1)/2] + nums2[nums2.length/2])/2.0 : nums2[(nums2.length-1)/2];
        }
        else if(nums2.length == 0)
        {
            return nums1.length%2==0 ? (nums1[(nums1.length-1)/2] + nums1[nums1.length/2])/2.0 : nums1[(nums1.length-1)/2];
        }
        int[] longs = nums1.length >= nums2.length ? nums1 : nums2;   //这里写过==，下面就不写了
        int[] shorts = nums1.length < nums2.length ? nums1 : nums2;
        if((nums1.length + nums2.length)%2 == 1)   //以下传参是 第几个数！
            return findKth(longs,shorts,(nums1.length + nums2.length + 1)/2);
        else
            return (findKth(longs,shorts,(nums1.length + nums2.length)/2) + findKth(longs,shorts,(nums1.length + nums2.length)/2+1))/2.0;
    }

    public static double findKth(int[] longs, int[] shorts, int k)  //即使是找中位数，但涉及到两个数组长度不一样，所以也要有下面三种情况的判断
    /**
     * @param k :第几小的数，而不是数组的角标
     */
    {
        int l = longs.length, s = shorts.length;
        if (k<=s)
            return GetUpMedian(shorts,0,k-1,longs,0,k-1);  //k<=s,实际上只会是s==k
        if (k>l)
        {
            if(shorts[k-l-1] >= longs[l-1])  return shorts[k-l-1];      //这里两个比较应该包括 =
            else if (longs[k-s-1] >= shorts[s-1]) return longs[k-s-1];   //角标-1是因为k是第几个，对应数组都要-1
            else return GetUpMedian(shorts,k-l,s-1,longs,k-s,l-1);  //因为上面k-l-1,k-s-1都测试过了不符合，所以从k-l,k-s开始
        }
        if(longs[k - s - 1] >= shorts[s -1])  return longs[k - s - 1];
        else
            return GetUpMedian(shorts,0, s-1,longs, k - s, k - 1);
    }

    public static int GetUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2)  //s=start,e=end,a1=shorts,a2=longs
    /**
     * @param s1 :短数组开始的角标
     * @param e1 :短数组结束的角标
     */
    {
        int mid1=0, mid2=0, offset=0;
        while (s1 < e1)
        {
            mid1 = (s1 + e1)/2;
            mid2 = (s2 + e2)/2;
            // 表示 2分查找要不要包含中间那个数 奇数是0，偶数是1，先 与，后 异或
            offset = ((e1 - s1 + 1) & 1) ^ 1;
            if (a1[mid1] > a2[mid2]) {
                e1 = mid1;
                s2 = mid2 + offset;
            } else if (a1[mid1] < a2[mid2]) {
                s1 = mid1 + offset;
                e2 = mid2;
            } else {
                return a1[mid1];
            }
        }
        return Math.min(a1[s1], a2[s2]);
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0){
            return findMedianSortedArrays(nums2);
        }
        if (nums2 == null || nums2.length == 0){
            return findMedianSortedArrays(nums1);
        }
        int l1 = nums1.length, l2 = nums2.length;
        int l = l1 + l2;
        int[] arr = new int[l];
        int p = l1 - 1, q = l2 - 1, i = l - 1;
        while ( p >= 0 && q >= 0){
            if (nums1[p] > nums2[q]){
                arr[i--] = nums1[p--];
            } else {
                arr[i--] = nums2[q--];
            }
        }
        while (p >= 0){
            arr[i--] = nums1[p--];
        }
        while (q >= 0){
            arr[i--] = nums2[q--];
        }
        if (l % 2 != 0){
            return arr[l/2];
        } else {
            return (arr[ l/ 2 - 1] + arr[l/2])/2.0;
        }

    }
    public double findMedianSortedArrays(int[] arr ) {
        int l = arr.length;
        if (l % 2 != 0){
            return arr[l/2];
        } else {
            return (arr[ l/ 2 - 1] + arr[l/2])/2.0;
        }
    }

    public static int findKthSmallest(int[] a, int m, int begin1, int[] b, int n, int begin2, int k)
    /**
     * @param m :数组a的长度
     * @param n :数组b的长度
     * a是长度较短的数组，b是较长的数组
     */
    {
        if (m > n)   //三种特殊情况的判断，
            return findKthSmallest(b, n, begin2, a, m, begin1, k);
        if (m == 0)
            return b[begin2 + k - 1];
        if (k == 1)
            return Integer.min(a[begin1], b[begin2]);

        int partA = Integer.min(k / 2, m), partB = k - partA;    //通过比较两个数组的中位数进行判断
        if (a[begin1 + partA - 1] == b[begin2 + partB - 1])
            return a[begin1 + partA - 1];
        else if (a[begin1 + partA - 1] > b[begin2 + partB - 1])
            return findKthSmallest(a, m, begin1, b, n - partB, begin2 + partB, k - partB);
        else
            return findKthSmallest(a, m - partA, begin1 + partA, b, n, begin2, k - partA);
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
        if (sumLen % 2 != 0)
        {
            return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1);
        }
        else
        {
            return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2)
                    + findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1)) / 2.0;
        }

    }

    public static void main(String[] algs)
    {
        int[] A = {1,4,8};
        int[] B = {2,3,6,7,9,10};
        //int[] A = {1};
        //int[] B = {1};
        Median_of_Two_Sorted_Arrays t = new Median_of_Two_Sorted_Arrays();
        System.out.println(t.findMedianSortedArrays(A,B));
    }
}
