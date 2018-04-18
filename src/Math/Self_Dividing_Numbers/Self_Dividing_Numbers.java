package Math.Self_Dividing_Numbers;

import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10)
            {
                if((j%10)==0 || (i%(j%10)) !=0) break;
            }
            if (j == 0) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Self_Dividing_Numbers t = new Self_Dividing_Numbers();
        System.out.println(t.selfDividingNumbers(1,22));
    }
}
