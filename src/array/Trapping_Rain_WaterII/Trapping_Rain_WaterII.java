package array.Trapping_Rain_WaterII;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Trapping_Rain_WaterII {
    public int trapRainWater(int[][] heightMap)
    {
        if(heightMap == null || heightMap.length <=2 || heightMap[0].length <=2) {
            return 0;
        }
        int[][] max = new int[heightMap.length][heightMap[0].length];
        for (int i = 1; i < heightMap[0].length - 1; i++) //列
        {
            int maxUp = heightMap[0][i], maxDown = heightMap[heightMap.length - 1][i];
            int up = 1, down = heightMap.length - 2;
            while (up <= down)
            {
                if(maxUp <= maxDown)
                {
                    max[up][i] = Math.max(0, maxUp - heightMap[up][i]);
                    maxUp = Math.max(maxUp, heightMap[up++][i]);
                }
                else
                {
                    max[down][i] = Math.max(0, maxDown - heightMap[down][i]);
                    maxDown = Math.max(maxDown, heightMap[down--][i]);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < heightMap.length - 1; i++) //行
        {
            int maxLeft = heightMap[i][0], maxRight = heightMap[i][heightMap[0].length - 1];
            int left = 1, right = heightMap[0].length - 2;
            while (left <= right)
            {
                if(maxLeft <= maxRight)
                {
                    max[i][left] = Math.min(max[i][left], maxLeft - heightMap[i][left]);
                    maxLeft = Math.max(maxLeft, heightMap[i][left++]);
                }
                else
                {
                    max[i][right] = Math.min(max[i][right], maxRight - heightMap[i][right]);
                    maxRight = Math.max(maxRight, heightMap[i][right--]);
                }
            }
        }

        for (int i = 0; i < max.length; i++)
        {
            for (int j = 0; j < max[0].length; j++)
            {
                sum += Math.max(0,max[i][j]);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Trapping_Rain_WaterII t = new Trapping_Rain_WaterII();
        int[][] heightMap = {{1, 4, 3, 1, 3, 2},
                             {3, 2, 1, 3, 2, 4},
                             {2, 3, 3, 2, 3, 1}};
        int[][] heightMap1 = {{12,13,1,12},
                              {13,4,13,12},
                              {13,8,10,12},
                              {12,13,12,12},
                              {13,13,13,13}};
        // int[][] heightMap1 = {{2,2,1},{3,1,2},{0,3,2}};
        System.out.println(t.trapRainWater(heightMap1));
    }
}

