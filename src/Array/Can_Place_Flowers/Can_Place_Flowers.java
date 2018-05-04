package Array.Can_Place_Flowers;

/**
 * Created by PennyLiu on 2018/5/3.
 */
public class Can_Place_Flowers {
    // 我们可以遍历花圃的所有元素，并找出那些为0的元素（暗示空位）。
    // 对于每个这样的元素，我们检查它的两个相邻位置是否也是空的。
    // 如果是这样，我们可以在当前位置种植一朵花，而不违反无邻近花卉规则。
    // 对于第一个和最后一个元素，我们不需要分别检查前一个和下一个相邻位置。
    public boolean canPlaceFlowers(int[] flowerbed, int n)
    {
        if (flowerbed == null || flowerbed.length == 0)
            return false;

        int res = 0;
        for (int i = 0; i < flowerbed.length; i++)
        {
            // 两个同时要满足的条件或一下，用与相连
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) &&
                    ( i == flowerbed.length -1 || flowerbed[i+1] ==0))
            {
                flowerbed[i] = 1; //可以填充
                res++;
            }
        }
        return res >= n;
    }

    // 可以优化的地方：在遍历过程中，一旦res==n，就返回true
    public boolean canPlaceFlowers1(int[] flowerbed, int n)
    {
        if (flowerbed == null || flowerbed.length == 0)
            return false;


        int res = 0;
        for (int i = 0; i < flowerbed.length; i++)
        {
            // 两个同时要满足的条件或一下，用与相连
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) &&
                    ( i == flowerbed.length -1 || flowerbed[i+1] ==0))
            {
                flowerbed[i] = 1; //可以填充
                res++;
            }
            if(res == n)
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Can_Place_Flowers t = new Can_Place_Flowers();
        int[] flowerbed = {1,0,0,0,0,0,1};
        int n = 3;
        System.out.println(t.canPlaceFlowers(flowerbed, n));
    }
}
