package redditCodingChallenges;

public class BaumSweet {

	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		for (int i = 0; i <= limit; i++) {
			System.out.print(baumSweet(i) + ", ");
		}
		System.out.println();
	}
	public static String toBinary(int n) {
		if (n <= 1) {
			return "" + n;
		} else {
			return toBinary(n/2) + n%2;
		}
	}
	public static int baumSweet(int n) {
		if (n == 0) {return 1;}
		String binarySequence = toBinary(n);
		int sequence = 0;
		for (int i = 0; i < binarySequence.length(); i++) {
			if (binarySequence.charAt(i) == '0') {
				sequence++;
			} else {
				if (sequence != 0 && sequence % 2 == 1) {
					return 0;
				}
				sequence = 0;
			}
		}
		if (sequence % 2 == 1) {
			return 0;
		}
		return 1;
	}
}
