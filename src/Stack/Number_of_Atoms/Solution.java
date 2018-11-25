package Stack.Number_of_Atoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/10/25
 */
//递归方法
class Solution {
    //用i计算解析到的位置，全局变量
    int i;
    public String countOfAtoms(String formula) {
        StringBuilder ans = new StringBuilder();
        Map<String, Integer> res = parse(formula);
        for (String name : res.keySet()) {
            ans.append(name);
            int count = res.get(name);
            if (count > 1) {
                ans.append("" + count);
            }
        }
        return new String(ans);
    }

    public Map<String,Integer> parse(String formula) {
        //用treemap可以自动针对首字母排序
        Map<String, Integer> digit = new TreeMap<>();
        int N = formula.length();
        while (i < N && formula.charAt(i) != ')') {
            //如果是（，就进入递归。然后把括号内的结果加入当前的map里
            if (formula.charAt(i) == '(') {
                i++;
                for (Map.Entry<String, Integer> entry:parse(formula).entrySet()) {
                    digit.put(entry.getKey(),digit.getOrDefault(entry.getKey(),0) + entry.getValue());
                }
            } else { //对括号内数据进行分析
                //start是第一个大写字母的位置，元素名字以大写开始，小写或数字结束
                int start = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                //含头不含尾
                String name = formula.substring(start,i);
                //第一个数字的位置
                start = i;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int times = start < i ? Integer.parseInt(formula.substring(start,i)) : 1;
                digit.put(name, digit.getOrDefault(name, 0) + times);
            }
        }
        //遇到),解析)后的数字。然后对前面计算出来的map中的每一项跟数字相乘。
        // start在 ）这个位置，即i所在的位置就是）
        int start = ++i;
        while (i < N && Character.isDigit(formula.charAt(i))) {
            i++;
        }
        if (start < i) {
            int times = Integer.parseInt(formula.substring(start,i));
            for (String key : digit.keySet()) {
                digit.put(key, digit.get(key) * times);
            }
        }
        return digit;
    }
}

//用栈
class SolutionStack{
    public String countOfAtoms(String formula) {
        int N = formula.length();
        //每个map对应一个括号，就像上面递归。递归过程是进入函数后系统帮你新建了map。
        Stack<Map<String,Integer>> stack = new Stack<>();
        //主函数内也要新建一个栈
        stack.push(new TreeMap<>());

        for (int i = 0; i < N;) {
            if (formula.charAt(i) == '(') {
                //要进入递归，所以新建一个栈
                stack.push(new TreeMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                //递归结束，看)后面的数字。弹出当前栈，把这一层的结果放回上一层
                Map<String, Integer> top = stack.pop();
                int start = ++i, times = 1;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > start) {
                   times = Integer.parseInt(formula.substring(start,i));
                }
                for (String key:top.keySet()) {
                    stack.peek().put(key,stack.peek().getOrDefault(key,0) + top.get(key) * times);
                }
            } else {
                //递归体内计算，存入当前这一层的栈内
                int start = i;
                while (i < N && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start,i);
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int times = i > start ? Integer.parseInt(formula.substring(start,i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name,0) + times);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1) ans.append("" + multiplicity);
        }
        return new String(ans);
    }
}