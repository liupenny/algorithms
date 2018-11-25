package array.Friends_Of_Appropriate_Ages;

/**
 * Created by PennyLiu on 2018/6/7.
 */
public class Friends_Of_Appropriate_Ages {
    public int numFriendRequests(int[] ages) {
        if(ages == null || ages.length == 0) {
            return 0;
        }

        int[] agecount = new int[121];
        for (int age: ages) {
            agecount[age]++;
        }

        int ans = 0;
        for (int i = 0; i < 121; i++) {
            if (agecount[i] > 0) {
                if (agecount[i] > 1) {
                    if (i < (i - 7) * 2) {
                        ans += agecount[i] * (agecount[i] - 1);
                    }
                }
                for (int j = 0; j < i; j++) {
                    if (agecount[j] > 0 && i < (j - 7) * 2) {
                        ans += agecount[i] * agecount[j];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Friends_Of_Appropriate_Ages t = new Friends_Of_Appropriate_Ages();
        int[] a = {16,16};
        int[] a1 = {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
        System.out.println(t.numFriendRequests(a1));
    }
}
