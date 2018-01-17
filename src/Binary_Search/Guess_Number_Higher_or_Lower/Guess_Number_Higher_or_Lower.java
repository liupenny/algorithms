package Binary_Search.Guess_Number_Higher_or_Lower;

/**
 * Created by PennyLiu on 2018/1/17.
 */

//public class Solution extends GuessGame {
//    public int guessNumber(int n) {
//        return binsearch(1,n);
//    }
//
//    private int binsearch(int start, int end)
//    {
//        if(guess(start)==0) return start;
//        if(guess(end)==0) return end;
//        int mid = start+(end-start)/2;
//        if(guess(mid)==0) return mid;
//        else if(guess(mid)==-1) return binsearch(start+1,mid-1);
//        else return binsearch(mid+1,end-1);
//    }
//}