package String.Parse_Lisp_Expression;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/16.
 */

public class Solution{
//    ArrayList<Map<String, Integer>> scope;
//    public Solution(){
//        scope = new ArrayList<>();
//        scope.add(new HashMap<>());
//    }
//
//    public int evaluate(String exp){
//        scope.add(new HashMap<>());
//        int ans = evaluate_inner(exp);
//        scope.remove(scope.size() - 1);
//        return ans;
//    }
//
//    public int evaluate_inner(String exp){
//        if(exp.charAt(0) != '('){
//            // 这个exp是数字
//            if(Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-')
//                return Integer.parseInt(exp);
//            //
//            for (int i = scope.size() - 1; i >= 0; --i) {
//                if(scope.get(i).containsKey(exp))
//                    return scope.get(i).get(exp);
//            }
//        }
//
//        //exp.charat(0) = '(', substring就是跳过mult ,add ,let 。直接到第一个表达式
//        List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
//        if(exp.startsWith("add",1)){
//            return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
//        }else if(exp.startsWith("mult",1)){
//            return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
//        }else {
//            for (int j = 1; j < tokens.size(); j += 2) {
//                scope.get(scope.size()-1).put(tokens.get(j-1), evaluate(tokens.get(j)));
//            }
//            return evaluate(tokens.get(tokens.size()-1));
//        }
//
//    }
//
//    // 提取表达式.一对（）内的内容会放一起
//    public List<String> parse(String exp){
//        List<String> ans = new ArrayList<>();
//        // bal记录括号是否平衡
//        int bal = 0;
//        // buf记录暂时括号内的表达式
//        StringBuilder buf = new StringBuilder();
//        //对每个空格分出来的表达式进行处理
//        for (String token:exp.split(" ")){
//            for (char c: token.toCharArray()) {
//                if(c == '(')
//                    bal++;
//                if(c == ')')
//                    bal--;
//            }
//            if(buf.length() > 0)
//                buf.append(" ");
//            //添加当前这个表达式
//            buf.append(token);
//            //表达式结束
//            if(bal == 0){
//                ans.add(new String(buf));
//                buf = new StringBuilder();
//            }
//        }
//        if(buf.length() > 0)
//            ans.add(new String(buf));
//        return ans;
//    }


    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private int eval(String exp, Map<String, Integer> parent) {
        //对表达式的解析，
        if (exp.charAt(0) != '(') {
            // just a number or a symbol
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                return Integer.parseInt(exp);
            }
            return parent.get(exp);
        }
        // create a new scope, add add all the previous values to it
        Map<String, Integer> map = new HashMap<>();
        // map中的条目是按照key来排序的
        map.putAll(parent);
        List<String> tokens = parse_exp(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
        if (exp.startsWith("(a")) { // add
            return eval(tokens.get(0), map) + eval(tokens.get(1), map);
        } else if (exp.startsWith("(m")) { // mult
            return eval(tokens.get(0), map) * eval(tokens.get(1), map);
        } else { // 因为是let表达式，所以每隔一位是一个变量，这里i就是遍历，i+1是这个变量的值。map每隔一个都会用val=eval(token(i+1))获取变量的值，然后map(token(i),val)放进去.
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                map.put(tokens.get(i), eval(tokens.get(i + 1), map));
            }
            //最后一步就是let表达式的返回值。
            return eval(tokens.get(tokens.size() - 1), map);
        }
    }

    // 提取表达式.一对（）内的内容会放一起,跟上面parse函数功能相同。只提取大括号的
    private List<String> parse_exp(String str) {
        // seperate the values between two parentheses
        List<String> res = new ArrayList<>();
        int par = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()) {
            if (c == '(') {
                par++;
            }
            if (c == ')') {
                par--;
            }
            if (par == 0 && c == ' ') {
                res.add(new String(sb));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            res.add(new String(sb));
        }
        return res;
    }



    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String a = "(let x 2 (add (let x 3 (let x 4 x)) x))";
        System.out.println(s.evaluate(a));

    }

}