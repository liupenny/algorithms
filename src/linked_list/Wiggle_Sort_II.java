/**
 * Created by PennyLiu on 2017/10/1.
 * leetcode: 324. Wiggle Sort II
 * 思路：首先找到整个数组中最中间的值median,按照快排中partition的思想，当找到后数组就已经是 L M S这样的排序状态了。
 * 此时，按照“L按照从左到右放在1 3 5，S在2 4 6这样的位置”规整顺序就能得到结果。
 * 具体参见：https://discuss.leetcode.com/topic/32861/3-lines-python-with-explanation-proof/2
 * 找出排序后的每个元素对应位置使用了radix函数
 */
public class Wiggle_Sort_II {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        // 类似于leetcode中 color sorts那个题，三类数排序
        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    /**
     * 索引函数的构造：
     * L（l的坐标<n/2）应该在奇数位置，S（s的坐标>n/2）应该在偶数位置。所以正确坐标应该是(1 + 2*i)%n
     * 然而(1 + 2*i)永远是奇数，当n是偶数时，mod n不改变奇偶性，会使得坐标映射结果重复。
     * e.g. Original Index => Mapped Index
     * 0 => (1 + 2 x 0) % 6 = 1 % 6 = 1
     * 1 => (1 + 2 x 1) % 6 = 3 % 6 = 3
     * 2 => (1 + 2 x 2) % 6 = 5 % 6 = 5

     * These are what's less than median, if we continue this with indexes 3, 4, 5 we will cycle again:
     * 3 => (1 + 2 x 3) % 6 = 7 % 6 = 1
     * 4 => (1 + 2 x 4) % 6 = 9 % 6 = 3
     * 5 => (1 + 2 x 5) % 6 = 11 % 6 = 5
     *
     * 所以需要 n | 1 得到奇数：
     * n = 6 for example 110 | 1 = 111 = 7
     * if n = 7 for example 111 | 1 = 111 = 7
     */
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
        // return index;
    }

    // O(n)的时间来找第K大的数
    public int findKthLargest(int[] nums, int k)
    {
        // k求的是第k大，所以按从大到小顺序的话应该求的中间那个数左边有k-1个值比他大
        k = k - 1;
        int begin = 0;
        int end = nums.length -1;
        int part;
        while (begin < end)
        {
            // 函数放在循环里面，不断修改begin 和 end
            part = partition(nums, begin ,end);
            if( k < part)
                end = part - 1;
            else if ( k > part)
                begin = part + 1;
            else if ( k == part)
                break;
        }
        // 直接按从大到小排序，返回k就是要求的
        return nums[k];
    }

    public static int partition(int[] nums, int lo, int hi)
    {
        int i = lo, j = hi + 1;
        int flag = nums[lo];
        while (true)
        {
            // 按照从大到小排序
            while ( nums[++i] >= flag) if(i == hi) break;
            while ( nums[--j] <= flag) if(j == lo) break;
            if(i >= j) break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }


    public static void swap(int[] nums, int i, int j)
    {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] algs)
    {
        Wiggle_Sort_II t = new Wiggle_Sort_II();
        int[] nums = {5, 8, 10, 2, 6, 7};
        t.wiggleSort(nums);
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i]);
    }
}
