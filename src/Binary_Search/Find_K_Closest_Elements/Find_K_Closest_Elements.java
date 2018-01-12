package Binary_Search.Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by PennyLiu on 2018/1/8.
 */
public class Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length-1, left = 0, right =n, mid, pivot;
        List<Integer> ans = new ArrayList<>();
        if (x >= arr[n])   //排除两个情况，》最大值
        {
            for(int i=k-1; i>=0; i--)
                ans.add(arr[n-i]);
            return ans;
        }
        if (x <= arr[0])    //《最小值
        {
            for(int i=0; i<k; i++)
                ans.add(arr[i]);
            return ans;
        }
        while (left < right)  // 找出最小的》x的那个数，
        {
            mid = left + ((right - left)>>1);
            if(arr[mid] < x)
                left = mid + 1;
            else
                right = mid;
        }
        pivot = right;
        int i = pivot - 1 ,j = pivot;
        while (k-->0)  //找出合适的值
        {
            if (i<0 || (j<=n && (Math.abs(arr[i]-x) > Math.abs(arr[j]-x))))  //只能是>不能 》，因为值相同的时候要选较小的值
                j++;
            else
                i--;
        }
        for (int t=i+1; t<j; t++)
            ans.add(arr[t]);
        return ans;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr, x);
        if(index < 0) index = -(index + 1);
        int i = index - 1, j = index;
        while(k-- > 0){
            if(i<0 || (j<arr.length && Math.abs(arr[i] - x) > Math.abs(arr[j] - x) ))j++;
            else i--;
        }
        // return arr.subList(i+1, j);  这部分跟现在的要求不一样，现在要求返回arraylist，所以要改
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        return ans;
    }

        public static void main(String[] algs)
    {
        int k=4,x=3;
        int[] arr={1,2,3,4,5};
        Find_K_Closest_Elements test = new Find_K_Closest_Elements();
        System.out.println(test.findClosestElements(arr,k,x));
    }
}
