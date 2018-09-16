package array.My_CalendarI;

import java.util.TreeMap;

/**
 * Created by PennyLiu on 2018/5/23.
 */
public class My_CalendarI {
    TreeMap<Integer, Integer> calendar;
    My_CalendarI()
    {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end)
    {
        Integer prev = calendar.floorKey(start), next = calendar.ceilingKey(start);
        if((prev == null || calendar.get(prev) <= start) && (next == null || end <= next))
        {
            calendar.put(start,end);
            return true;
        }
        return false;
    }

}
