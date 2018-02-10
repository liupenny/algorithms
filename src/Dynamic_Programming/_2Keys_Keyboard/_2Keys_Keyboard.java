package Dynamic_Programming._2Keys_Keyboard;

public class _2Keys_Keyboard {
    public int minSteps(int n) {
        if(n<1 || n>1000) return 0;

        int res = 0;
        for (int i = 2; i <= n; i++)
        {
            while(n%i==0)  //要用while，而不是if
            {
                res+=i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _2Keys_Keyboard t = new _2Keys_Keyboard();
        System.out.println(t.minSteps(5));
    }
}
