package array.RevealCardsInIncreasingOrder;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/2
 */
public class Solution {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i) {
            index.add(i);
        }

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] d = {17,13,11,2,3,5,7};
        deckRevealedIncreasing(d);
    }
}
