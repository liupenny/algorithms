package Backtracking.Gray_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/7.
 */
public class Gray_Code {
    public List<Integer> grayCode(int n)
    {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++)
        {
            res.add(i^i >> 1);
        }
        return res;
    }

    public static void main(String[] args)
    {
        Gray_Code t = new Gray_Code();

    }
}
