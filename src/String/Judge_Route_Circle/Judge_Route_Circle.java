package String.Judge_Route_Circle;

// 因为是从（0,0）点开始，所以不会再往下
//  python: 直接统计次数，但是java没有这样的函数。
// return moves.count('L') == moves.count('R') and moves.count('U') == moves.count('D')
public class Judge_Route_Circle {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++)
        {
            if(moves.charAt(i) == 'L') {
                x--;
            } else if(moves.charAt(i) == 'R') {
                x++;
            } else if(moves.charAt(i) == 'U') {
                y++;
            } else if(moves.charAt(i) == 'D') {
                y--;
            }
        }
        return (x == 0) && (y == 0) ? true : false;
    }

    public static void main(String[] args) {
        Judge_Route_Circle t = new Judge_Route_Circle();
        System.out.println(t.judgeCircle("UDDLR"));
    }
}
