package Dynamic_Programming.Money_Problem;

public class Code_08_Money_Problem {

	public static boolean money1(int[] arr, int aim)
	{
		return process1(arr, 0, 0, aim);
	}

	public static boolean process1(int[] arr, int i, int sum, int aim) {
		/**
		 * i:前面i个数的选择都选择完了。i位置之后还能选
		 * sum：前面选择好之后的累加和sum
		 * 返回：i位置之后还能自由选择的情况下，返回能不能组成aim
		 */
		if (sum == aim) {  //如果已经得到aim就返回
			return true;
		}
		if (i == arr.length) {   //已经到了数组末尾还没有加出来aim，证明加不出来
			return false;
		}
		// 第一个分支：i位置不要，sum不变；或者要当前位置，将sum+自己的值。因为结果是布尔值，所以是||.
		return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
	}

	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][aim] = true;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = aim - 1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + arr[i] <= aim) {
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
		System.out.println(money1(arr, aim));
		System.out.println(money2(arr, aim));
	}

}
