package Stack.Baseball_Game;

public class Baseball_Game {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0) return 0;

        int[] res = new int[ops.length];
        int sum = 0, turn = 0;
        for (int i = 0; i < ops.length; i++)
        {
            if(ops[i].equals(String.valueOf('+')))
            {
                res[turn] = res[turn - 1] + res[turn - 2];
                sum += res[turn];
                turn++;
            }
            else if(ops[i].equals(String.valueOf('C')))
            {
                sum -= res[turn-1];
                res[--turn] = 0;
            }
            else if(ops[i].equals(String.valueOf('D')))
            {
                res[turn] = res[turn-1]*2;
                sum += res[turn];
                turn++;
            }
            else
            {
                sum += Integer.valueOf(ops[i]);
                res[turn++] = Integer.valueOf(ops[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Baseball_Game t = new Baseball_Game();
        //System.out.println(t.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(t.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
