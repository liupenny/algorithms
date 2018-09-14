package Sort.H_Index;

/**
 * Created by PennyLiu on 2018/1/11.
 */
public class H_Index {
    public int hIndex(int[] citations) {
        int[] help = new int[citations.length + 1];
        for(int i = 0; i < citations.length; i++)  //桶排序
        {
            if(citations[i] >= citations.length) {
                help[citations.length]++;
            } else {
                help[citations[i]]++;
            }
        }
        int sum = 0;
        for(int j = help.length - 1; j >=0; j--)
        {
            sum += help[j];
            if(sum >= j) {
                return j;
            }
        }
        return 0;
    }
}
