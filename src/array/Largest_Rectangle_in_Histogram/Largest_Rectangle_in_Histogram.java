package array.Largest_Rectangle_in_Histogram;

import java.util.Stack;

/**
 * Created by PennyLiu on 2018/6/8.
 */
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int[] len = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int leftMax = i, rightMax = i;
            while (leftMax - 1 >= 0 && heights[leftMax - 1] >= heights[i])
            {
                    leftMax -= 1;

            }
            while (rightMax + 1 <= heights.length - 1 && heights[rightMax + 1] >= heights[i])
            {
                    rightMax += 1;
            }
            len[i] = rightMax - leftMax + 1;
        }

        int erea = 0;
        for (int i = 0; i < heights.length; i++) {
            erea = Math.max(erea, heights[i] * len[i]);
        }
        return erea;
    }

    // 单调栈
    public int largestRectangleArea_stack(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) //当前元素<=栈顶元素，所以不断弹出栈中的元素
            {
                int center = stack.pop(); //弹出栈顶元素的时候就是知道栈顶元素右边第一个比他小的数的时候，所以此时计算栈顶元素作为中心的面积
                int left = stack.isEmpty() ? -1 : stack.peek();  //弹出的栈顶元素左边第一个比他小的元素就是栈顶下面的那个数
                int curArea = (i - left -1) * heights[center]; //right 和 left的坐标都是比栈顶小的元素，所以要- 1
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) //处理剩下的这些元素，这些元素右边全是比他们大的，所以
        {
            int center = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (heights.length - left - 1) * heights[center];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Largest_Rectangle_in_Histogram t = new Largest_Rectangle_in_Histogram();
        int[] heights = {2,1,5,6,2,3};
        int[] heights1 = {3,5,8,1,6,7};
        System.out.println(t.largestRectangleArea_stack(heights));
    }
}
