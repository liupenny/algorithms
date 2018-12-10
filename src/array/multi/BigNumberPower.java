package Array.multi;
/*

 */
public class BigNumberPower {
   /**
    * @Author liu Ruiqing
    * @Description  11的n次方
    * @Date 2018/12/10
    * @Param [n]
    * @return java.lang.String
    **/
    // 该数字首个不为空的数值位置
    int firstNoneZeroPos;
    int size;
    public String powerOf11(int n) {
        size = 2*n;
        int[] tmp = new int[size];
        tmp[size - 1] = 1;
        tmp[size - 2] = 1;
        firstNoneZeroPos = size - 2;
        for (int i = 1; i < n; i++) {
            times(tmp);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = firstNoneZeroPos; i < size; i++) {
            ans.append(tmp[i]);
        }
        return ans.toString();
    }

    /**
     * @Author liu Ruiqing
     * @Description  TODO
     * @Date 2018/12/10
     * @Param [num]
     * @return int[]
     **/
    public int[] times(int[] num) {
        for (int i = firstNoneZeroPos; i < size; i++) {
            num[i-1] = num[i];
        }
        num[size-1] = 0;
        firstNoneZeroPos -= 1;
        int carry = 0;
        for (int i = size - 1; i > firstNoneZeroPos; i--) {
            int tmp = num[i] + num[i-1] + carry;
            carry = tmp/10;
            num[i] = tmp%10;
        }
        if (carry == 1) {
            num[firstNoneZeroPos] += 1;
        }
        return num;
    }

    /**
     * @Author liu Ruiqing
     * @Description  两个大数相乘
     * @Date 2018/12/10
     * @Param [a, b]
     * @return int[]
     **/
    public String mulOfBigNum(int[] a, int[] b) {
        int lena = a.length, lenb = b.length;
        int[] res = new int[lena+lenb];
        for (int i = 0; i < lena; i++) {
            for (int j = 0; j < lenb; j++) {
                res[i+j] += a[i]*b[j];
            }
        }

        for (int i = res.length-1; i > 0; i--) {
            res[i-1] += res[i]/10;
            res[i] %= 10;
        }

        StringBuilder s = new StringBuilder();
        boolean isBegin = false;
        for (int num : res) {
            if (!isBegin && num != 0) {
                isBegin = true;
                s.append(num);
            } else if (isBegin) {
                s.append(num);
            }
        }
        return s.toString();
    }


    /**
     * @Author liu Ruiqing
     * @Description  两个大整数相加，顺序存储，返回结果数据res
     * @Date 2018/12/10
     * @Param [a, b]
     * @return int[]
     **/
    public String sumOfBigNum(int[] a, int[] b) {
        int lena = a.length, lenb = b.length;
        int lenMax = (lena >= lenb ? lena : lenb) + 1;
        int[] res = new int[lenMax];
        int carry = 0;
        int i,j,k;
        for (i = lena - 1, j = lenb - 1, k = lenMax - 1; i >= 0 && j >= 0 ; i--, j--, k--) {
            int tmp = (carry + a[i] + b[j]);
            res[k] = tmp%10;
            carry = tmp/10;
        }
        if (i < 0) {
            while (j >= 0) {
                int tmp = (carry + b[j--]);
                res[k--] = tmp%10;
                carry = tmp/10;
            }
        } else if (j < 0) {
            while (i >= 0) {
                int tmp = (carry + a[i--]);
                res[k--] = tmp%10;
                carry = tmp/10;
            }
        }
        if (carry != 0) {
            res[k] = 1;
        }
        StringBuilder s = new StringBuilder();
        for(int x = 0; x < res.length; x++ ) {
            if (x == 0 && res[x] == 0) {
                continue;
            }
            s.append(res[x]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        BigNumberPower b = new BigNumberPower();
        int[] a = {9,9,9,9}, c = {1};
        System.out.println(b.mulOfBigNum(a,c));
    }
}
