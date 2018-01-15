package Binary_Search.Kth_Smallest_Number_in_Multiplication_Table;

/**
 * Created by PennyLiu on 2018/1/12.
 */
public class Kth_Smallest_Number_in_Multiplication_Table {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m*n, mid, cou;
        while (left < right)
        {
            mid = left + (right - left) / 2;
            cou = count(m,n,mid);
            if(cou >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }

    public int count(int m, int n, int mid)
    {
        int cou = 0;
        for (int i = 1; i<=m; i++)
            cou += Math.min(mid/i,n);
        return cou;
    }

    public static void main(String[] algs)
    {
        Kth_Smallest_Number_in_Multiplication_Table t = new Kth_Smallest_Number_in_Multiplication_Table();
        System.out.println(t.findKthNumber(3,6,7));
    }
}
