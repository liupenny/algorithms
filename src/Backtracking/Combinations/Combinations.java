package Backtracking.Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/11.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> res = new ArrayList<>(); // 泛型要一样
        if(n == 0 || k == 0) {
            return res;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        help(temp, k, n, 1, res);
        return res;
    }

    public void help(ArrayList<Integer> list, int k, int n, int start, List<List<Integer>> res)
    {
        if(list.size() == k)
        {
            res.add(new ArrayList(list)); //List < List< Integer>> res 添加（add）List< Integer> list，是添加 list 的引用。
                                          // 即，若更改 list 的内容，res 中的内容也被修改了
            // res.add(list); //list传的是地址，如果这么写每次添加的都是一样的东西。所以要新建一个对象。上面的写法是根据当前内容新建一个对象
            return;
        }

        for (int i = start; i <= n; i++)
        {
            list.add(i);
            if(list.size() + n -start >= k) {
                help(list, k, n, i + 1, res);
            }
            list.remove(list.size() - 1);
            // list.remove() 有两种重载形式，一种参数为对象，另一种参数为下标。
            // 若对象本身是普通类型，如整型，那么java默认将整型看做是下标
        }
    }

    public static void main(String[] args) {
        Combinations t = new Combinations();
        int n = 4, k = 2;
        System.out.println(t.combine(n,k));
    }
}
