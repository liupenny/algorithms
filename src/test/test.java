package test;

/**
 * Created by PennyLiu on 2018/5/13.
 */
public class test {
    public int back(int[] val, int mount)
    {
        int[] f = new int[mount+1];
        for (int i = 1; i < val.length; i++)
        {
            for (int j = mount; j >= val[i] ; j--)
            {
                if(f[j] < f[j-val[i]] + val[i])
                    f[j] = f[j-val[i]] + val[i];
            }
        }
        return f[mount];
    }

    public static void main(String[] args) {
        test t = new test();
        int[] val = {8,3,12,7,9,7};
        int mount = 24;
        System.out.println(t.back(val, mount));
    }
}
