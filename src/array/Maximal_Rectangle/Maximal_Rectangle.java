package array.Maximal_Rectangle;

import java.util.Stack;

/**
 * Created by PennyLiu on 2018/6/7.
 */
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int ans = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;  //每一行累加起来，算此时的连续的高度
            }
            ans = Math.max(largestRectangleArea_stack(height), ans);  // 每一行算一下面积
        }
        return ans;
    }

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
        Maximal_Rectangle t = new Maximal_Rectangle();
        char[][] matrix= {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}};
       System.out.println(t.maximalRectangle(matrix));
    }
}
