package Greedy.Couples_Holding_Hands;

/**
 * Created by PennyLiu on 2018/5/2.
 */
public class Couples_Holding_Hands
{
    public int minSwapsCouples(int[] row)
    {
        int res = 0, N = row.length;
        int[] ptn = new int[N];
        int[] pos = new int[N];

        for (int i = 0; i < N; i++)
        {
            ptn[i] = (i%2 == 0 ? i+1 : i-1); // 标签值为i的伙伴的标签值
            pos[row[i]] = i;  //pos表示 row[i]这个标签在row中的索引是i
        }

        for (int i = 0; i < N; i++)
        {
            // j是row[i]这个标签应该在的位置
            for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]])
            {
                swap(row, i, j); //交换这两个标签的位置
                swap(pos, row[i], row[j]);
                res++;
            }
        }

        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Couples_Holding_Hands t = new Couples_Holding_Hands();
        int[] row = {3, 2, 0, 1};
        System.out.println(t.minSwapsCouples(row));
    }
}
