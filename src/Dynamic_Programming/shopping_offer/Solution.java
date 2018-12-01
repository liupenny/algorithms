package Dynamic_Programming.shopping_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/23
 */
public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }
    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int localMin = getlocalMin(price, needs);
        for (int i = pos; i < special.size(); i++) {
            List<Integer> curSpecial = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < price.size(); j++) {
                if (needs.get(j) < curSpecial.get(j)) {
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - curSpecial.get(j));
            }
            if (temp != null) {
                localMin = Math.min(localMin, curSpecial.get(curSpecial.size() - 1) + helper(price, special, temp, i));}
        }
        return localMin;
    }
    private int getlocalMin(List<Integer> price, List<Integer> needs) {
        int localMin = 0;
        for (int i = 0; i < needs.size(); i++) {
            localMin += price.get(i) * needs.get(i);
        }
        return localMin;
    }


}
