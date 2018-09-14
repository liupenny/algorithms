package Binary_Search.Heaters;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/1/12.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {    //对每一个house找出最合适的radius
        Arrays.sort(houses);  //先排序
        Arrays.sort(heaters);
        int ans = 0, numheat = 0;

        for (int house:houses)
        {
            while (numheat<heaters.length-1 && heaters[numheat]+heaters[numheat+1] <= house*2) {
                numheat++;
            }
            ans = Math.max(ans,Math.abs(heaters[numheat]-house));
        }
        return ans;
    }

    public int findRadius1(int[] houses, int[] heaters) {    //对每一个house找出最合适的radius
        Arrays.sort(houses);  //先排序
        Arrays.sort(heaters);
        int ans = 0, dis = 0;

        for (int house:houses)
        {
            int index = Arrays.binarySearch(heaters,house);
            if(index<0) {
                index = -(index + 1);
            }

            if(index ==0) {
                ans = Math.max(ans, heaters[0] - house);
            }
            if(index == heaters.length) {
                ans = Math.max(ans, house - heaters[heaters.length - 1]);
            }
            if(index>0 && index<heaters.length) {
                ans = Math.max(ans, Math.min(heaters[index] - house, house - heaters[index - 1]));
            }
        }
        return ans;
    }

    public static void main(String[] algs)
    {
        int[] houses = {1,2,3}, heaters = {2};
        Heaters t = new Heaters();
        System.out.println(t.findRadius1(houses,heaters));
    }
}
