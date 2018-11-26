package Binary_Search.FloorAndCeil;

import java.util.Arrays;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/23
 */
public class Solution {
    private static Integer[] generateRandomOrderedArray(int n, int rangeL, int rangeR){

        Integer[] arr = new Integer[n];

        for(int i = 0 ; i < n ; i ++) {
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }
        Arrays.sort(arr);
        return arr;
    }

    // 二分查找法, 实现lower_bound
    // 即在一个有序数组arr中, 寻找大于等于target的元素的第一个索引
    // 如果存在, 则返回相应的索引index
    // 否则, 返回arr的元素个数 n
    public static int lower_bound(Comparable[] arr, Comparable target){

        if(arr == null) {
            throw new IllegalArgumentException("arr can not be null.");
        }

        int l = 0, r = arr.length;
        while(l != r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else    // nums[mid] >= target
            {
                r = mid;
            }
        }
        return l;
    }

    // 二分查找法, 实现upper_bound
    // 即在一个有序数组arr中, 寻找大于target的元素的第一个索引
    // 如果存在, 则返回相应的索引index
    // 否则, 返回arr的元素个数 n
    public static int upper_bound(Comparable[] arr, Comparable target){

        if(arr == null) {
            throw new IllegalArgumentException("arr can not be null.");
        }

        int l = 0, r = arr.length;
        while(l != r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else    // nums[mid] > target
            {
                r = mid;
            }
        }
        return l;
    }

    // 大于target的第一个元素
    static int upper(Comparable[] arr, Comparable target) {
        if (target.compareTo(arr[arr.length - 1]) > 0) {
            return -1;
        }
//        if (target.compareTo(arr[0]) < 0) {
//            return 0;
//        }

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (arr[mid].compareTo(target) > 0) {
                if (mid == 0 || arr[mid-1].compareTo(target) <= 0) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    static int floor(Comparable[] arr, Comparable target) {
        if (target.compareTo(arr[0]) < 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r -l) /2;
            if (arr[mid].compareTo(target) <= 0) {
                if (mid == arr.length - 1 || arr[mid+1].compareTo(target) > 0) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // 》
    static int bsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else { //小于
                low = mid + 1;
            }
        }
        return -1;
    }

    static int ceil(Comparable[] arr, Comparable target){
        if (target.compareTo(arr[arr.length-1]) > 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l)>>1);
            if (arr[mid].compareTo(target) >= 0) {
                if((mid ==0) || arr[mid - 1].compareTo(target) < 0) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6};
        int[] a = {1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6};

        for( int i = 0 ; i <= 8 ; i ++ ){

//            int floorIndex = floor(arr, i);
//            System.out.println("the floor index of " + i + " is " + floorIndex + ".");
//            if( floorIndex >= 0 && floorIndex < arr.length ) {
//                System.out.println("The value is " + arr[floorIndex] + ".");
//            }
//            System.out.println();

//            int lowerIndex = lower_bound(arr, i);
//            System.out.println("the lower index of " + i + " is " + lowerIndex + ".");
//            if( lowerIndex >= 0 && lowerIndex < arr.length ) {
//                System.out.println("The value is " + arr[lowerIndex] + ".");
//            }
//            System.out.println();

            int upperIndex = upper(arr, i);
            System.out.println("the upper index of " + i + " is " + upperIndex + ".");
            if( upperIndex >= 0 && upperIndex < arr.length ) {
                System.out.println("The value is " + arr[upperIndex] + ".");
            }
            System.out.println();

//            int ceilIndex = ceil(arr, i);
//            System.out.println("the ceil index of " + i + " is " + ceilIndex + ".");
//            if( ceilIndex >= 0 && ceilIndex < arr.length ) {
//                System.out.println("The value is " + arr[ceilIndex] + ".");
//            }
//            System.out.println();
//
//            int bsIndex = bsearch(a, i);
//            System.out.println("the bs index of " + i + " is " + bsIndex + ".");
//            if( bsIndex >= 0 && bsIndex < a.length ) {
//                System.out.println("The value is " + a[bsIndex] + ".");
//            }
//            System.out.println();
//
//            System.out.println();
        }
    }
}
