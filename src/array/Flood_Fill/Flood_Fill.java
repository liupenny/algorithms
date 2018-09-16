package array.Flood_Fill;

import java.util.LinkedList;

/**
 * Created by PennyLiu on 2018/4/18.
 */
public class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        if (image == null || image.length == 0 || sr < 0 || sr > image.length || sc < 0 || sc > image[0].length) {
            return image;
        }
        int oldColor = image[sr][sc];
        if(oldColor == newColor) {
            return image;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int pos = sr * image[0].length + sc;
        image[sr][sc] = newColor;
        queue.offer(pos);
        while (!queue.isEmpty())
        {
            pos = queue.poll();
            int row = pos/image[0].length;
            int col = pos%image[0].length;
            if(row > 0 && image[row - 1][col] == oldColor)  //判断上面位置的值是不是O
            {
                queue.offer((row - 1) * image[0].length + col);
                image[row - 1][col] = newColor;
            }
            if(row < image.length - 1 && image[row + 1][col] == oldColor) //判断下面位置的值是不是O
            {
                queue.offer((row + 1) * image[0].length + col);
                image[row + 1][col] = newColor;
            }
            if(col > 0 && image[row][col - 1] == oldColor)  //判断左边位置的值是不是O
            {
                queue.offer(row * image[0].length + col - 1);
                image[row][col - 1] = newColor;
            }
            if(col < (image[0].length -1 ) && image[row][col + 1] == oldColor)  //判断右边位置的值是不是O
            {
                queue.offer(row * image[0].length + col + 1);
                image[row][col + 1] = newColor;
            }
        }
        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j < image[0].length; j++)
            {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
        return image;
    }

    public static void main(String[] args)
    {
//        int[][] num = {{0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}};
        int[][] num = {{0,0,0},
                {0,1,1}};
        Flood_Fill a = new Flood_Fill();
        int sr = 1, sc = 1, newColor = 1;
        //System.out.println(a.floodFill(num, sr, sc, newColor));
        a.floodFill(num, sr, sc, newColor);
    }
}
