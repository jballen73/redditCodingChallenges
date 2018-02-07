package redditCodingChallenges;

public class BowlingFramesDisplay {

	public static void main(String[] args) {
		int[] scores = toIntArray(args);
		int frame = 0;
		int shot = 0;
		int index = 0;
		int prevShot = 0;
		String[] display = new String[10];
		while (frame < 9) {
			int curShot = scores[index];
			switch(shot) {
			case 0:
				if (curShot == 10) {
					display[frame] = "X ";
					frame++;
				} else if (curShot == 0) {
					prevShot = curShot;
					display[frame] = "-";
					shot++;
				} else {
					prevShot = curShot;
					display[frame] = "" + curShot;
					shot++;
				}
				break;
			case 1:
				if (curShot + prevShot == 10) {
					display[frame] += "/ ";
					shot--;
					frame++;
				} else if (curShot == 0) {
					display[frame] += "- ";
					shot--;
					frame++;
				} else {
					display[frame] += curShot + " ";
					shot--;
					frame++;
				}
				break;
			}
			index++;
		}
		if (scores[index] == 10) {
			display[9] = "X";
			if (scores[++index] == 10) {
				display[9] += "X";
				if (scores[++index] == 10) {
					display[9] += "X";
				} else if (scores[index] == 0) {
					display[9] += "-";
				} else {
					display[9] += scores[index];
				}
			} else if (scores[index] == 0) {
				display[9] += "-";
				if (scores[++index] == 0) {
					display[9] += "-";
				} else if (scores[index] == 10) {
					display[9] += "/";
				} else {
					display[9] += scores[index];
				}
			} else {
				prevShot = scores[index];
				display[9] += prevShot;
				if (scores[++index] == 0) {
					display[9] += "-";
				} else if (scores[index] + prevShot == 10) {
					display[9] += "/";
				} else {
					display[9] += scores[index];
				}
			}
		} else {
			prevShot = scores[index];
			if (scores[index] == 0) {
				display[9] = "-";
			} else {
				display[9] = "" + prevShot;
			}
			if (scores[++index] + prevShot == 10) {
				display[9] += "/";
				if (scores[++index] == 10) {
					display[9] += "X";
				} else if (scores[index] == 0) {
					display[9] += "-";
				} else {
					display[9] += scores[index];
				}
			} else if (scores[index] == 0) {
				display[9] += "-";
			} else {
				display[9] += scores[index];
			}
		}
		display(display);
		
	}
	public static int[] toIntArray(String[] s) {
		int[] nums = new int[s.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(s[i]);
		}
		return nums;
	}
	public static void display(String[] display) {
		for (String s : display) {
			System.out.print(s);
		}
	}
}
