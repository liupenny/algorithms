package Array.multi;

public class BigNumberPower {
    // 11的n次方
    public int[] powerOf11(int n) {
        int size = 2*n;
        int[] tmp = new int[size];
        int[] cur = new int[size];
        for(int i = 0; i < size; i++) {
            tmp[i] = -1;
            cur[i] = -1;
        }
        tmp[size - 1] = 1;
        tmp[size - 2] = 1;
        for (int i = 0; i < n; i++) {
            cur = times(tmp);
            tmp = cur;
        }
        return
    }

    public int[] times(int[] num) {
        int firstPos = -1;
        int n = num.length - 1;
        for (int i = 0; i <= n  ; i++) {
            if (firstPos == -1 && num[i] != 0) {
                firstPos = i;
                num[i-1] = num[i];
            }
        }
        int carry = 0;
        for (int i = num.length - 1; i > firstPos-1; i--) {
            int tmp = num[i] + num[i-1];
            carry = (carry + tmp)/10;
            num[i] = tmp%10;
        }
        if (carry == 1) {
            num[firstPos-1] = 1;
        }
        return num;
    }

    //两个大数相乘
    public int[] mulOfBigNum(int[] a, int[] b) {

    }
}
