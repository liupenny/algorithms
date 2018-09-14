package Backtracking.Binary_Watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/7/16.
 */

public class Solution{
    List<String> ans = new ArrayList<>();
    int[] times = new int[10];
    public List<String> readBinaryWatch(int num) {
        if(num < 0 || num > 8) {
            return ans;
        }

        compute(ans, num, 0, times, 0);
        return ans;
    }

    public void compute(List<String> ans, int num, int tmpNum, int[] times, int timeIndex)
    {
        if(tmpNum == num) {
            int hour = 0, minute = 0;
            for (int i = 0; i < 4; i++) {
                hour += times[i] != 0 ? Math.pow(2.0, i) : 0;
            }
            for (int i = 4; i < times.length; i++) {
                minute += times[i] != 0 ? Math.pow(2.0, i - 4) : 0;
            }
            if(hour > 11 || minute > 59) {
                return;
            }
            String min = minute < 10 ? "0" + minute : String.valueOf(minute);
            ans.add(hour + ":" + min);
            return;
        }

        if(timeIndex == times.length) {
            return;
        }
        times[timeIndex] = 1;
        compute(ans, num, tmpNum + 1,times, timeIndex + 1);
        times[timeIndex] = 0;
        compute(ans, num, tmpNum,times, timeIndex + 1);
    }

    public List<String> readBinaryWatch_map(int num) {
        List<String> list = new ArrayList<>();
        if (num >= 9) {
            return list;
        }
        //hours[i]表示有i个灯亮的时候可能的小时值，构成一个列表；
        //minutes[i]同上。
        String[][] hours = new String[][] {{"0"}, {"1", "2", "4", "8"}, {"3", "5", "9", "10", "6"}, {"7", "11"}};
        String[][] minutes = new String[][] {{"00"}, {"01", "02", "04", "08", "16", "32"}, {"03", "05", "09", "17", "33", "06", "10", "18", "34", "12", "20", "36", "24", "40", "48"}, {"07", "11", "19", "35", "13", "21", "37", "25", "41", "49", "14", "22", "38", "26", "42", "50", "28", "44", "52","56"}, {"15", "23", "39", "29", "45", "27", "43", "51", "53", "57", "30", "46", "54", "58"}, {"31", "47", "55", "59"}};

        // 先从分钟开始，如果分钟数全占满了，往小时数调整一些
        int h = 0;
        int m = num;
        while (m > 5) {
            h++;
            m--;
        }

        // 直接拼接即可
        while (m >= 0 && h <= 3) {
            String[] hour = hours[h];
            String[] minute = minutes[m];
            for (int i = 0; i < hour.length; i++) {
                for (int j = 0; j < minute.length; j++) {
                    list.add(hour[i] + ":" + minute[j]);
                }
            }
            m--;
            h++;
        }
        return list;
    }

    public static void main(String[] args)
    {
        int s = 1;
        Solution a = new Solution();
        System.out.println(a.readBinaryWatch(s));
    }
}