package Array.Insert_Delete_GetRandom_O1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by PennyLiu on 2018/5/25.
 */
public class Insert_Delete_GetRandom_O1 {
    private RandomizedSet s = new RandomizedSet();

    class RandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> locs;
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) { //添加的时候直接加，value写数组长度是为了判断当前元素在arraylist中的位置
            boolean contain = locs.containsKey(val);
            if(contain) {
                return false;
            }
            locs.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) //删的时候
        {
            boolean contain = locs.containsKey(val);
            if(!contain) {
                return false;
            }
            int loc = locs.get(val);
            if(loc < nums.size() - 1) // not the last one then swap the last one with this val, 当前数不是最后一个就用这个数和最后一个交换
            {
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone); //(index,val)
                locs.put(lastone, loc);
            }
            //是最后一个就直接删除
            locs.remove(val);
            nums.remove(nums.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        Insert_Delete_GetRandom_O1 t = new Insert_Delete_GetRandom_O1();
    }
}
