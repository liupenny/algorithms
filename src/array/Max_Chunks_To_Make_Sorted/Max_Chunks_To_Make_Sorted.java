package array.Max_Chunks_To_Make_Sorted;

/**
 * Created by PennyLiu on 2018/5/8.
 */
public class Max_Chunks_To_Make_Sorted {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int res = 1;
        for (int i = 0, maxn = 0; i < arr.length; i++)
        {
            maxn = Math.max(maxn, arr[i]);
            if(maxn == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Max_Chunks_To_Make_Sorted t = new Max_Chunks_To_Make_Sorted();
        int[] arr = {1,0,2,3,4};
        System.out.println(t.maxChunksToSorted(arr));
    }
}
