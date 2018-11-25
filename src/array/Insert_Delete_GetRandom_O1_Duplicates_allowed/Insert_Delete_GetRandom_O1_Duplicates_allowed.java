package array.Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

/**
 * Created by PennyLiu on 2018/5/25.
 */
public class Insert_Delete_GetRandom_O1_Duplicates_allowed {
    class RandomizedCollection {
        HashMap<Integer, Set<Integer>> valueToPosition;
        List<Integer> nums;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            valueToPosition = new HashMap<>();
            nums = new ArrayList<>();
            rand = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {  //不管原来是否存在都添加
            valueToPosition.putIfAbsent(val, new HashSet<>());
            valueToPosition.get(val).add(nums.size());
            nums.add(val);
            return valueToPosition.get(val).size() == 1; //添加完，如果大小=1那么证明原来不存在，返回true；否则返回false
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!valueToPosition.containsKey(val)) {
                return false;
            }
            int currentPos = valueToPosition.get(val).iterator().next();

            // 在nums中将val的最后一个位置存储nums里最后一个数
            int lastOne =  nums.get(nums.size()-1); //lastone是nums里的最后一个数
            nums.set(currentPos, lastOne);

            // 在hash表中把val对应的位置删除
            valueToPosition.get(val).remove(currentPos);
            // 在hash表中把最后一个数的位置进行相应的添加删除
            valueToPosition.get(lastOne).add(currentPos);
            valueToPosition.get(lastOne).remove(nums.size()-1);

            // 在Nums表里删除
            nums.remove(nums.size()-1);
            // 如果这个数已经不存在了要删除，否则下一次要删除的时候会判断失误
            if(valueToPosition.get(val).size() == 0) {
                valueToPosition.remove(val);
            }

            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        Insert_Delete_GetRandom_O1_Duplicates_allowed t = new Insert_Delete_GetRandom_O1_Duplicates_allowed();
    }
}
