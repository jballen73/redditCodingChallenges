package redditCodingChallenges;

public class RabbitProblem {
	private static long[] female = new long[97];
	private static long[] male = new long[97];
	public static void main(String[] args) {
		male[2] = Integer.parseInt(args[0]);
		female[2] = Integer.parseInt(args[1]);
		long rabbitTarget = Long.parseLong(args[2]);
		int months = 0;
		do {
			long births = calcBirths();
			incAges();
			female[0] = births * 9;
			male[0] = births * 5;
			months++;
		} while (totalRabbits() < rabbitTarget);
		System.out.println(months);

	}
	public static long totalRabbits() {
		long total = 0;
		for (int i = 0; i < 96; i++) {
			total += female[i];
			total += male[i];
		}
		return total;
	}
	public static long calcBirths() {
		long total = 0;
		for (int i = 4; i < 96; i++) {
			total += female[i];
		}
		return total;
	}
	public static void incAges() {
		female[96] += female[95];
		male[96] += male[95];
		for (int i = 95; i >= 1; i--) {
			female[i] = female[i-1];
			male[i] = male[i-1];
		}
	}
}

