package Array.My_CalendarIII;

import java.util.TreeMap;

/**
 * Created by PennyLiu on 2018/5/23.
 */
public class My_CalendarIII {
    private MyCalendarThree calendarThree = new MyCalendarThree();

    class MyCalendarThree
    {

        TreeMap<Integer, Integer> calendar;

        public MyCalendarThree() {
            calendar = new TreeMap<>();
        }

        public int book(int start, int end) {
            calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            calendar.put(end, calendar.getOrDefault(end, 0) - 1);
            int active = 0, res = 0;
            for (Integer i : calendar.values()) {
                active += i;
                res = active > res ? active : res;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        My_CalendarIII s = new My_CalendarIII();

        System.out.println(s.calendarThree.book(10, 20)); // returns 1
        System.out.println(s.calendarThree.book(50, 60)); // returns 1
        System.out.println(s.calendarThree.book(10, 40)); // returns 2
        System.out.println(s.calendarThree.book(5, 15)); // returns 3
        System.out.println(s.calendarThree.book(5, 10)); // returns 3
        System.out.println(s.calendarThree.book(25, 55)); // returns 3
    }
}
