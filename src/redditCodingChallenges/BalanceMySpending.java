package redditCodingChallenges;

public class BalanceMySpending {
	public static int[] preSum;
	public static int[] currValue;
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		preSum = new int[size];
		currValue = new int[size];
		for (int i = 1; i < args.length; i++) {
			if (i != 1) {
				preSum[i-1] = preSum[i-2] + Integer.parseInt(args[i-1]);
			}
			currValue[i-1] = Integer.parseInt(args[i]);
		}
		int total = currValue[size-1] + preSum[size-1];
		for (int i = 0; i < size; i++) {
			if (preSum[i] == total - preSum[i] - currValue[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
