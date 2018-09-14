package Backtracking.Beautiful_ArrangementII;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;

/**
 * Created by PennyLiu on 2018/4/30.
 */
public class Beautiful_ArrangementII {
    public int[] constructArray(int n, int k)
    {
        int[] ans = new int[n];
        for (int cnt = 0, i = 1, j = n; i <= j; cnt++)
        {
            if(k > 1)  //不能是 >= 1,否则如果k=1，生成的结果k会>1
            {
                if(k % 2 == 0) {
                    ans[cnt] = i++;
                } else {
                    ans[cnt] = j--;
                }
                k--;
            }
            else  //这一步要考虑到：1-- 原要求k>1,减到剩1，这时候还要从后面取一个，否则结果k少1。 2--原k就是1，逆序从后面取即可
            {
                ans[cnt] = j--;
            }
        }
        for (int num:ans) {
            System.out.print(num + " ");
        }
        return ans;
    }



    public static void main(String[] args) {
        Beautiful_ArrangementII t = new Beautiful_ArrangementII();
        System.out.print(t.constructArray(3,2));
    }
}
