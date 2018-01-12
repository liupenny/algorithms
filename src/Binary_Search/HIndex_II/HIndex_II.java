package Binary_Search.HIndex_II;

/**
 * Created by PennyLiu on 2018/1/11.
 *
 * The basic idea of this solution is to use binary search to find the minimum index such that

 citations[index] >= length(citations) - index
 After finding this index, the answer is length(citations) - index.

 This logic is very similar to the C++ function lower_bound or upper_bound.
 */
public class HIndex_II {
    public int hIndex(int[] citations) {
        int left = 0, size = citations.length, mid, step,count=size;  //就是要用二分找到最小的index， citations[index] >= length(citations) - index
        while (count > 0)
        {
            step = count/2;
            mid = left + step;
            if(citations[mid] < size-mid)
            {
                left = mid + 1;
                count -= (step + 1);
            }
            else
                count = step;
        }
        return size - left;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n-1;
        int middle;
        while (start <= end){
            middle = (end-start)/2 + start;
            if (citations[middle] == n-middle) return citations[middle];  //左边不可能有，右边值更小
            else if(citations[middle] < n-middle) start = middle + 1;
            else end = middle - 1;
        }
        return n - end - 1;
    }

    public static void main(String[] algs)
    {
        int[] arr={1,2,4,4,5,6,7};
        HIndex_II test = new HIndex_II();
        System.out.println(test.hIndex2(arr));
    }
}
