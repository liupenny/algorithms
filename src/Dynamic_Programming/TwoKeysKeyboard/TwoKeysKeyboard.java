package Dynamic_Programming.TwoKeysKeyboard;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if(n<1 || n>1000) {
            return 0;
        }

        int res = 0;
        for (int i = 2; i <= n; i++)
        {
            //要用while，而不是if
            while(n%i==0)
            {
                res+=i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard t = new TwoKeysKeyboard();
        System.out.println(t.minSteps(5));
    }
}
