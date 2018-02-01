package Hash_Table.Distribute_Candies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distribute_Candies {
    public int distributeCandies(int[] candies) {
        if(candies == null || candies.length == 0) return 0;

        Set<Integer> help = new HashSet<>(Arrays.asList(candies));

    }

    public static void main(String[] args) {
        Distribute_Candies t = new Distribute_Candies();
        System.out.println(t.distributeCandies(new int[]{1,1,2,2,3,3}));
    }
}
