package Binary_Search.First_Bad_Version;

/**
 * Created by PennyLiu on 2018/1/17.
 */
//public class Solution extends VersionControl {
//    public int firstBadVersion(int n) {
//        return binsearch(1,n);
//    }
//
//    public int binsearch(int start, int end)
//    {
//        int left = start, right = end, mid;
//        while(left<right)
//        {
//            mid = left + (right - left)/2;
//            if(isBadVersion(mid)==true)
//                right = mid;
//            else
//                left = mid + 1;
//        }
//        return right;
//    }
//}