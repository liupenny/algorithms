package Array.Trapping_Rain_Water;


/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Trapping_Rain_Water {
    public int trap(int[] height)
    {
        if (height == null || height.length <= 2)
            return 0;

        int maxLeft = height[0], maxRight = height[height.length - 1];
        int sum = 0, l = 1, r = height.length - 2;
        while (l <= r)
        {
            if(maxLeft <= maxRight)
            {
                sum += Math.max(0, maxLeft - height[l]);
                maxLeft = Math.max(maxLeft, height[l++]);
            }
            else
            {
                sum += Math.max(0, maxRight - height[r]);
                maxRight = Math.max(maxRight, height[r--]);
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Trapping_Rain_Water t = new Trapping_Rain_Water();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(height));
    }
}
