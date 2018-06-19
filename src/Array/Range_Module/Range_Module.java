package Array.Range_Module;

import tools.Interval;

import java.util.*;

/**
 * Created by PennyLiu on 2018/6/8.
 */
public class Range_Module {
    class RangeModule {
        TreeMap<Integer, Integer> map;

        public RangeModule() {
            map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            if(left >= right)
                return;

            // start,end是比left,right小的key
            Integer start = map.floorKey(left);
            Integer end = map.floorKey(right);
            if(start == null && end == null) //没有比left,start小的起点
                map.put(left, right);
            else if(start != null && map.get(start) >= left) //有比left小的开头，且这一段的结尾大于left，所以合并为start到（right, start对应结尾，end对应结尾）的最大值
                map.put(start, Math.max(map.get(end), Math.max(right, map.get(start))));
            else //start=null,end!=null.合并为left，到(right,end对应结尾)的最大值
                map.put(left, Math.max(right, map.get(end)));

            // 删除left和right之间的interval，因为上面考虑了比left,right小的全部，所以这就把上面考虑过的删除,因为left是加上去的，所以不考虑
            Map<Integer, Integer> subMap = map.subMap(left,false,right,true);
            Set<Integer> set = new HashSet(subMap.keySet());
            map.keySet().removeAll(set);
        }

        public boolean queryRange(int left, int right) {
            Integer start = map.floorKey(left);
            if(start == null)
                return false;
            return map.get(start) >= right;
        }

        public void removeRange(int left, int right) {
            if(right <= left)
                return;
            Integer start = map.floorKey(left);
            Integer end = map.floorKey(right);
            // 这里注意顺序，先考虑end，再是start
            if(end != null && map.get(end) > right)
                map.put(right,map.get(end));
            if(start != null && map.get(start) > left)
                map.put(start,left);
            //清理中间的部分，right是这一轮加上去的，所以不考虑
            Map<Integer, Integer> subMap = map.subMap(left,true,right,false);
            Set<Integer> set = new HashSet<>(subMap.keySet());
            map.keySet().removeAll(set);
        }
    }


    public static void main(String[] args) {
        Range_Module t = new Range_Module();
    }
}
