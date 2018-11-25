package Stack.MaximumFrequencyStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/10/25
 */
public class FreqStack {
    // map存储值，次数
    // stack按照入栈的顺序，存储一个频率对应的所有值
    //maxfreq记录最大频率
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> stack;
    int maxfreq;

    public FreqStack() {
        map = new HashMap<>(10000);
        stack = new HashMap<>(10000);
        maxfreq = 0;
    }

    //两个map都放
    public void push(int x) {
        int f = map.getOrDefault(x,0) + 1;
        map.put(x, f);
        maxfreq = Math.max(f, maxfreq);
        //如果stack中对应的频率没有值，新建
        if(!stack.containsKey(f)) {
            stack.put(f, new Stack<Integer>());
        }
        stack.get(f).add(x);
    }
    //弹出时两个map都更新
    public int pop() {
        int x = stack.get(maxfreq).pop();
        map.put(x, maxfreq - 1);
        //对应最大频率的栈没值了。减一
        if (stack.get(maxfreq).size() == 0) {
            maxfreq--;
        }
        return x;
    }
}

