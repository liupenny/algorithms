package heap.Kth_Largest_Element_in_an_Array;
import java.util.Random;

/**
 * Created by PennyLiu on 2017/10/1.
 * leetcode: 215.Kth Largest Element in an Array
 * 思路：使用快排partition的思想
 */
public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k)
    {
        // 先打乱数组
        shuffle(nums);
        // k求的是第k大，所以按从大到小顺序的话应该求的中间那个数左边有k-1个值比他大，partition返回的是左边有多少个比pivot大的数！！
        k = k - 1;
        int begin = 0;
        int end = nums.length -1;
        int part;
        while (begin < end)
        {
            // 函数放在循环里面，不断修改begin 和 end
            part = partition(nums, begin ,end);
            if( k < part) {
                end = part - 1;
            } else if ( k > part) {
                begin = part + 1;
            } else if ( k == part) {
                break;
            }
        }
        // 直接按从大到小排序，返回k就是要求的
        return nums[k];
    }

    //partition返回的是左边有多少个比pivot大的数!!
    public static int partition(int[] nums, int lo, int hi)
    {
        int i = lo, j = hi + 1;
        int flag = nums[lo];
        while (true)
        {
            // 按照从大到小排序
            while ( nums[++i] >= flag) {
                if (i == hi) {
                    break;
                }
            }
            while ( nums[--j] <= flag) {
                if (j == lo) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }

    // （水塘抽样算法），但其实产生重复也没关系，因为是相互交换
    public static void shuffle(int[] nums)
    {
        final Random random = new Random();
        int ran;
        for (int i = 0; i < nums.length; i++)
        {
            ran = random.nextInt(i+1);
            swap(nums,i,ran);
        }
    }

    public static void swap(int[] nums, int i, int j)
    {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] algs)
    {
        Kth_Largest_Element_in_an_Array test = new Kth_Largest_Element_in_an_Array();
        int[] a = {5, 8, 10, 2, 6, 7};
        System.out.println(test.findKthLargest(a,3));
    }
}
