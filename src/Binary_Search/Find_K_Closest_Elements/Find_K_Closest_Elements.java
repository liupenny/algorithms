package Binary_Search.Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/1/8.
 */
public class Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length-1, left = 0, right =n, mid, pivot;
        List<Integer> ans = new ArrayList<>();
        if (x >= arr[n])
        {
            for(int i=k-1; i>=0; i--)
                ans.add(arr[n-i]);
            return ans;
        }
        if (x <= arr[0])
        {
            for(int i=0; i<k; i++)
                ans.add(arr[i]);
            return ans;
        }
        while (left < right)  //找出最小的》x的那个数，
        {
            mid = left + (right - left +1)>>1;
            if(arr[mid] >= x)
                right = mid;
            else
                left = mid + 1;
        }
        pivot = right;
        ans.add(0);
        return ans;
    }

    public static void main(String[] algs)
    {
        int k=3,x=2;
        int[] arr={1,2,3,4,5};
        Find_K_Closest_Elements test = new Find_K_Closest_Elements();
        System.out.println(test.findClosestElements(arr,k,x));
    }
}
