package Array.My_CalendarII;

import java.util.TreeMap;

/**
 * Created by PennyLiu on 2018/5/23.
 */
public class My_CalendarII {
    private MyCalendarTwo calendarTwo = new MyCalendarTwo();

    class MyCalendarTwo
    {
        TreeMap<Integer, Integer> calendar;
        
        public MyCalendarTwo() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            calendar.put(end, calendar.getOrDefault(end, 0) - 1);
            int active = 0;
            for (Integer i : calendar.values()) {
                active += i;
                if (active == 3) {
                    calendar.put(start, calendar.getOrDefault(start, 0) - 1);
                    calendar.put(end, calendar.getOrDefault(end, 0) + 1);
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        My_CalendarII s = new My_CalendarII();

        System.out.println(s.calendarTwo.book(10, 20)); // returns 1
        System.out.println(s.calendarTwo.book(50, 60)); // returns 1
        System.out.println(s.calendarTwo.book(10, 40)); // returns 2
        System.out.println(s.calendarTwo.book(5, 15)); // returns 3
        System.out.println(s.calendarTwo.book(5, 10)); // returns 3
        System.out.println(s.calendarTwo.book(25, 55)); // returns 3
    }
    
}
