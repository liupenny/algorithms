package Array.Pascals_TriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/25.
 */
public class Pascals_TriangleII {
    public List<Integer> getRow(int rowIndex)
    {
        Integer[] arr = new Integer[rowIndex+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }

        return Arrays.asList(arr);
    }

    public static void main(String[] args)
    {
        Pascals_TriangleII t = new Pascals_TriangleII();
        int rowIndex = 3;
        System.out.println(t.getRow(rowIndex));
    }
}
