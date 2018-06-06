package Hash_Table.Jewels_and_Stones;

public class Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        if(S == null || S.length() == 0) return 0;

        int ans = 0;
        for (int i = 0; i < S.length(); i++)
        {
            if(J.contains(String.valueOf(S.charAt(i))))
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Jewels_and_Stones t = new Jewels_and_Stones();
        System.out.println(t.numJewelsInStones("z", "ZZ"));
    }
}
