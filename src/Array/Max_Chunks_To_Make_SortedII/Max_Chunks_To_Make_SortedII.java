package Array.Max_Chunks_To_Make_SortedII;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/8.
 */
public class Max_Chunks_To_Make_SortedII {
    // 因为有重复元素，可以考虑判断累加和的方式，
    // 排序后的数组前i个元素累加的和等于原数组前i个数累加的和时可以分为一个块
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;

        int sum1 = 0, sum2 = 0, ans = 0;
        int[] t = arr.clone();
        Arrays.sort(t);
        for (int i = 0; i < arr.length; i++)
        {
            sum1 += t[i];
            sum2 += arr[i];
            if(sum1 == sum2)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Max_Chunks_To_Make_SortedII t = new Max_Chunks_To_Make_SortedII();
        int[] arr = {1,4,2,3,4};
        System.out.println(t.maxChunksToSorted(arr));
    }
}
