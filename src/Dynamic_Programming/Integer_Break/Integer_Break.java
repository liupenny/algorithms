package Dynamic_Programming.Integer_Break;

public class Integer_Break {
    public int integerBreak(int n) {
        if(n==2) return 1;
        else if(n==3) return 2;
        else if(n%3==0) return (int)Math.pow(3.0, n/3);
        else if(n%3==1) return (int)Math.pow(3.0, (n-4)/3)*4;  //不能取3，就取2，这时候模余1，所以剩下4，取4
        else return (int)Math.pow(3.0, (n-2)/3)*2;
    }

    public static void main(String[] args) {
        Integer_Break t = new Integer_Break();
        System.out.println(t.integerBreak(5));
    }
}
