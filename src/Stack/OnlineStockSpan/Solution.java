package Stack.OnlineStockSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/10/25
 */
class StockSpanner {
    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));
    }
}

class StockSpanner1 {
    List<Integer> l = new ArrayList<Integer>();
    List<Integer> s = new ArrayList<Integer>();
    int prevSpan = 1;
    public StockSpanner1() {

    }

    public int next(int price) {
        l.add(price);
        int span = 1;

        int prevIndex = l.size() - 2;

        while(prevIndex > -1 && price >= l.get(prevIndex)) {
            span = span + s.get(prevIndex);
            prevIndex = prevIndex - s.get(prevIndex);
        }

        s.add(span);
        return span;
    }

    public static void main(String[] args) {
        StockSpanner1 s = new StockSpanner1();
        System.out.println(s.next(11));
        System.out.println(s.next(5));
        System.out.println(s.next(6));
        System.out.println(s.next(7));
        System.out.println(s.next(8));
        //System.out.println(s.next(75));
        //System.out.println(s.next(85));
    }
}
