package Stack.Basic_CalculatorIV;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/11.
 */

//public class Solution{
//    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
//        Map<String, Integer> evalMap = new HashMap<>();
//        for (int i = 0; i < evalvars.length; i++) {
//            evalMap.put(evalvars[i], evalints[i]);
//        }
//        return parse(expression).evaluate(evalMap).toList();
//    }
//
//    public Poly make(String expr) {
//        Poly ans = new Poly();
//        List<String> list = new ArrayList();
//        if (Character.isDigit(expr.charAt(0))) {
//            ans.update(list, Integer.valueOf(expr));
//        } else {
//            list.add(expr);
//            ans.update(list, 1);
//        }
//        return ans;
//    }
//
//    public Poly combine(Poly left, Poly right, char symbol){
//        if (symbol == '+') return left.add(right);
//        if (symbol == '-') return left.sub(right);
//        if (symbol == '*') return left.mul(right);
//        throw null;
//    }
//
//    public Poly parse(String expr) {
//        List<Poly> bucket = new ArrayList();
//        List<Character> symbols = new ArrayList();
//        int i = 0;
//        while (i < expr.length()) {
//            if (expr.charAt(i) == '(') {
//                int bal = 0, j = i;
//                for (; j < expr.length(); ++j) {
//                    if (expr.charAt(j) == '(') bal++;
//                    if (expr.charAt(j) == ')') bal--;
//                    if (bal == 0) break;
//                }
//                bucket.add(parse(expr.substring(i + 1, j)));
//                i = j;
//            } else if (Character.isLetterOrDigit(expr.charAt(i))) {
//                int j = i;
//                search:
//                {
//                    for (; j < expr.length(); ++j)
//                        if (expr.charAt(j) == ' ') {
//                            bucket.add(make(expr.substring(i, j)));
//                            break search;
//                        }
//                    bucket.add(make(expr.substring(i)));
//                }
//                i = j;
//            } else if (expr.charAt(i) != ' ') {
//                symbols.add(expr.charAt(i));
//            }
//            i++;
//        }
//
//        for (int j = symbols.size() - 1; j >= 0; --j)
//            if (symbols.get(j) == '*')
//                bucket.set(j, combine(bucket.get(j), bucket.remove(j+1), symbols.remove(j)));
//
//        if (bucket.isEmpty()) return new Poly();
//        Poly ans = bucket.get(0);
//        for (int j = 0; j < symbols.size(); ++j)
//            ans = combine(ans, bucket.get(j+1), symbols.get(j));
//
//        return ans;
//    }
//}
//
//class Poly{
//    HashMap<List<String>, Integer> count;
//    Poly(){
//        count = new HashMap<>();
//    }
//
//    void update(List<String> key, int val){
//        this.count.put(key, this.count.getOrDefault(key,0) + val);
//    }
//
//    Poly add(Poly that){
//        Poly ans = new Poly();
//        for (List<String> k: this.count.keySet()) {
//            ans.update(k,this.count.get(k));
//        }
//        for (List<String> k: that.count.keySet()) {
//            ans.update(k,that.count.get(k));
//        }
//        return ans;
//    }
//
//    Poly sub(Poly that){
//        Poly ans = new Poly();
//        for (List<String> k: this.count.keySet())
//            ans.update(k, this.count.get(k));
//        for (List<String> k: that.count.keySet())
//            ans.update(k, -that.count.get(k));
//        return ans;
//    }
//
//    Poly mul(Poly that) {
//        Poly ans = new Poly();
//        for (List<String> k1: this.count.keySet())
//            for (List<String> k2: that.count.keySet()) {
//                List<String> kNew = new ArrayList();
//                for (String x: k1) kNew.add(x);
//                for (String x: k2) kNew.add(x);
//                Collections.sort(kNew);
//                ans.update(kNew, this.count.get(k1) * that.count.get(k2));
//            }
//        return ans;
//    }
//
//    Poly evaluate(Map<String, Integer> evalMap) {
//        Poly ans = new Poly();
//        for (List<String> k: this.count.keySet()) {
//            int c = this.count.get(k);
//            List<String> free = new ArrayList();
//            for (String token: k) {
//                if (evalMap.containsKey(token))
//                    c *= evalMap.get(token);
//                else
//                    free.add(token);
//            }
//            ans.update(free, c);
//        }
//        return ans;
//    }
//
//    int compareList(List<String> A, List<String> B) {
//        int i = 0;
//        for (String x: A) {
//            String y = B.get(i++);
//            if (x.compareTo(y) != 0) return x.compareTo(y);
//        }
//        return 0;
//    }
//
//    List<String> toList() {
//        List<String> ans = new ArrayList();
//        List<List<String>> keys = new ArrayList(this.count.keySet());
//        Collections.sort(keys, (a, b) ->
//                a.size() != b.size() ? b.size() - a.size() : compareList(a, b));
//
//        for (List<String> key: keys) {
//            int v = this.count.get(key);
//            if (v == 0) continue;
//            StringBuilder word = new StringBuilder();
//            word.append("" + v);
//            for (String token: key) {
//                word.append('*');
//                word.append(token);
//            }
//            ans.add(word.toString());
//        }
//        return ans;
//    }
//}
//
class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        String expression = "e + 8 - a + 5";
        String[] evalvars = {"e"};
        int[] evalints = {1};
        s.basicCalculatorIV(expression, evalvars, evalints);
    }
}

class Solution {
    Map<String,Integer> map=new HashMap<>(); //evaluation map
    class Term
    {
        // 这里的var里面都是要相乘的元素
        int para=1; //the parameter of this term
        List<String> var=new ArrayList<>(); //each factor (e.a. a*b*b*c->{a,b,b,c})
        @Override
        public String toString()
        {
            if (para==0) {
                return "";
            }
            String ans="";
            for (String s:var) {
                ans += "*" + s;
            }
            return para+ans;
        }
        // 判断两个val是否相等
        boolean equals(Term that)
        {
            if (this.var.size()!=that.var.size()) {
                return false;
            }
            for (int i=0;i<this.var.size();i++) {
                if (!this.var.get(i).equals(that.var.get(i))) {
                    return false;
                }
            }
            return true;
        }
        // 比较两个val大小，谁长度小，谁在前面；长度相等就比较每个字符
        int compareTo(Term that)
        {
            if (this.var.size()>that.var.size()) {
                return -1;
            }
            if (this.var.size()<that.var.size()) {
                return 1;
            }
            for (int i=0;i<this.var.size();i++)
            {
                int x=this.var.get(i).compareTo(that.var.get(i));
                if (x!=0) {
                    return x;
                }
            }
            return 0;
        }
        // 两个term相乘
        Term times(Term that)
        {
            Term pro=new Term(this.para*that.para);
            for (String s:this.var) {
                pro.var.add(new String(s));
            }
            for (String s:that.var) {
                pro.var.add(new String(s));
            }
            Collections.sort(pro.var);
            return pro;
        }
        // 初始化这个term的长度
        Term(int x) { para=x; }
        Term(String s) { if (map.containsKey(s)) {
            para = map.get(s);
        } else {
            var.add(s);
        }
        }
        Term(Term that) { this.para=that.para; this.var=new ArrayList<>(that.var); }
    }

    class Expression
    {
        List<Term> list=new ArrayList<>(); //Term List
        char oper='+'; // Arithmetic symbol
        Expression(int x) { list.add(new Term(x)); }
        Expression(String s) { list.add(new Term(s)); }
        Expression(List<Term> l) { list=l; }
        Expression times(Expression that)
        {
            List<Term> c=new ArrayList<>();
            for (Term t1:this.list) {
                for (Term t2 : that.list) {
                    c.add(t1.times(t2));
                }
            }
            c=combine(c);
            return new Expression(c);
        }
        Expression plus(Expression that,int sgn)
        {
            List<Term> c=new ArrayList<>();
            for (Term t:this.list) {
                c.add(new Term(t));
            }
            for (Term t:that.list)
            {
                Term t2=new Term(t);
                t2.para=t2.para*sgn;
                c.add(t2);
            }
            c=combine(c);
            return new Expression(c);
        }
        Expression cal(Expression that)
        {
            if (oper=='+') {
                return plus(that, 1);
            }
            if (oper=='-') {
                return plus(that, -1);
            }
            return times(that);
        }
        List<String> toList()
        {
            List<String> ans=new ArrayList<>();
            for (Term t:list)
            {
                String s=t.toString();
                if (s.length()>0) {
                    ans.add(s);
                }
            }
            return ans;
        }
    }

    List<Term> combine(List<Term> a) //combine the similar terms
    {
        Collections.sort(a,(t1,t2)->(t1.compareTo(t2))); //sort all terms to make similar terms together
        List<Term> c=new ArrayList<>();
        for (Term t:a)
        {
            if (c.size()!=0 && t.equals(c.get(c.size()-1))) {
                c.get(c.size() - 1).para += t.para;
            } else {
                c.add(new Term(t));
            }
        }
        return c;
    }

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        for (int i=0;i<evalvars.length;i++) {
            map.put(evalvars[i], evalints[i]);
        }

        int i=0,l=expression.length();
        //表达式和其优先级
        Stack<Expression> stack=new Stack<>();
        Stack<Integer> priStack=new Stack<>();
        Expression zero=new Expression(0);
        stack.push(zero);
        priStack.push(0);
        int pri=0;
        while (i<l)
        {
            char ch=expression.charAt(i);
            //存数字
            if (Character.isDigit(ch))
            {
                int num=0;
                while (i<l && Character.isDigit(expression.charAt(i)))
                {
                    num=num*10+(expression.charAt(i)-48);
                    i++;
                }
                stack.add(new Expression(num));
                continue;
            }
            if (Character.isLetter(ch))
            {
                String s="";
                while (i<l && Character.isLetter(expression.charAt(i)))
                {
                    s+=expression.charAt(i);
                    i++;
                }
                stack.add(new Expression(s));
                continue;
            }
            if (ch=='(') {
                pri += 2;
            }
            if (ch==')') {
                pri -= 2;
            }
            if (ch=='+' || ch=='-' || ch=='*')
            {
                int nowPri=pri;
                if (ch=='*') {
                    nowPri++;
                }
                while (!priStack.isEmpty() && nowPri<=priStack.peek())
                {
                    Expression now=stack.pop(),last=stack.pop();
                    priStack.pop();
                    stack.push(last.cal(now));
                }
                stack.peek().oper=ch;
                priStack.push(nowPri);
            }
            i++;
        }
        while (stack.size()>1)
        {
            Expression now=stack.pop(),last=stack.pop();
            stack.push(last.cal(now));
        }
        return stack.peek().toList();
    }
}