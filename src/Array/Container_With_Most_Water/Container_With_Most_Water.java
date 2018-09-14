package Array.Container_With_Most_Water;

/**
 * Created by PennyLiu on 2018/6/1.
 */
public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }

        int len = height.length, ans = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return ans;
    }

    public int maxArea_pointer(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxarea = 0, left = 0, right = height.length - 1;
        while (left < right)
        {
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        Container_With_Most_Water t = new Container_With_Most_Water();
        int[] height = {2, 1};
        System.out.println(t.maxArea(height));
    }
}
