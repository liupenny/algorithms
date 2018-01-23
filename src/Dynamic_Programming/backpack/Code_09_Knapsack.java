package Dynamic_Programming.backpack;

public class Code_09_Knapsack {

	public static int maxValue1(int[] c, int[] p, int bag) {
		return process1(c, p, 0, 0, bag);
	}

	public static int process1(int[] weight, int[] values, int i, int already, int bag) {
		// already: o-(i-1)已选定了，之前货物的重量是already
		// weight,values是不变的
		// 返回i往后自由选择的重量是多少
		if (already > bag) {   //如果在任何一步，背包超了就返回0或者最小价值
			return Integer.MIN_VALUE;
		}  //当已经到最后一个了，没得选了返回0
		if (i == weight.length) {
			return 0;
		}
		return Math.max(process1(weight, values, i + 1, already, bag), values[i] + process1(weight, values, i + 1, already + weight[i], bag));
	}

	public static int maxValue2(int[] c, int[] p, int bag) {
		int[][] dp = new int[c.length + 1][bag + 1];
		for (int i = c.length - 1; i >= 0; i--) {
			for (int j = bag; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + c[i] <= bag) {
					dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] c = { 3, 2, 4, 7 };
		int[] p = { 5, 6, 3, 19 };
		int bag = 11;
		System.out.println(maxValue1(c, p, bag));
		System.out.println(maxValue2(c, p, bag));
	}

}
