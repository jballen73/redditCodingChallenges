package redditCodingChallenges;

import java.util.Arrays;

public class MajorScales {

	public static void main(String[] args) {
		String[] notes = new String[12];
		notes[0] = "C";
		notes[1] = "C#";
		notes[2] = "D";
		notes[3] = "D#";
		notes[4] = "E";
		notes[5] = "F";
		notes[6] = "F#";
		notes[7] = "G";
		notes[8] = "G#";
		notes[9] = "A";
		notes[10] = "A#";
		notes[11] = "B";
		int offset = Arrays.asList(notes).indexOf(args[0]);
		System.out.println(notes[(offset + solfegeToIndex(args[1]))%12]);
		

	}
	public static int solfegeToIndex(String s) {
		switch(s) {
		case "Do":
			return 0;
		case "Re":
			return 2;
		case "Mi":
			return 4;
		case "Fa":
			return 5;
		case "So":
			return 7;
		case "La":
			return 9;
		case "Ti":
			return 11;
			default:
				return 0;
		}
	}
}
