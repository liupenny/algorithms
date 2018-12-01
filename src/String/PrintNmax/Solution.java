package String.PrintNmax;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/27
 */
public class Solution {
    int[] res;
    int bigPos;
    public void printNmax(int n) {
        res = new int[n+1];
        bigPos = n;
        while (addOne() != false) {
            outRes();
        }
    }

    public boolean addOne(){
        int idx = res.length - 1;
        if (bigPos != 0) {
            res[idx]++;
            while (res[idx] % 10 == 0) {
                if (idx - 1 != 0) {
                    res[idx - 1]++;
                    res[idx] = 0;
                    idx--;
                    bigPos = Math.min(bigPos,idx);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void outRes(){
        StringBuilder numStr = new StringBuilder();
        for (int i = bigPos; i < res.length; i++) {
            numStr.append(res[i]);
        }
        System.out.println(numStr.toString());
    }

    public void printNmax1(int n) {
        char[] res = new char[n];
        for (int i = 0; i < 10; i++) {
            res[0] = (char)(i+'0');
            perm(res,n,0);
        }
    }

    public void perm(char[] res, int length, int index) {
        if (index == length - 1) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < 10; i++) {
            res[index+1] = (char) (i + '0');
            perm(res,length,index + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printNmax1(3);
    }
}
