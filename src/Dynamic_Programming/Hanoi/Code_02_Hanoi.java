package Dynamic_Programming.Hanoi;

public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
			func1(n, n, "left", "mid", "right");
		}
	}

	public static void func1(int res, int N, String from, String mid, String to) { //res是还剩几个，n是当前最底下的圆盘是第几号圆盘，from是当前所在的位置，
		if (res == 1) {  //res是指from位置当前还剩几个圆盘
			System.out.println("move " + N + from + " to " + to);
		} else {
			func1(res - 1, N-1, from, to, mid);   //n-1个盘子借助to移到mid上,此时最下面的盘子是N-1
			func1(1, N, from, mid, to);
			func1(res - 1, N-1, mid, from, to);
		}
	}

	public static void func(int n, String from, String mid, String to) { //n是还剩几个圆盘，from是当前所在的位置，
		if (n == 1) {  //n是指from位置当前还剩几个圆盘
			System.out.println("move from " + from + " to " + to);
		} else {
			func(n - 1, from, to, mid);   //n-1个盘子借助to移到mid上
			func(1, from, mid, to);
			func(n - 1, mid, from, to);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
