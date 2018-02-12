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
            switch (shot) {
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
        shot = 0;
        while (frame == 9) {
            int curShot = scores[index];
            switch (shot) {
            case 0:
                prevShot = curShot;
                if (prevShot == 10) {
                    display[frame] = "X";
                    shot++;
                } else if (prevShot == 0) {
                    display[frame] = "-";
                    shot++;
                } else {
                    display[frame] = "" + prevShot;
                    shot++;
                }
                break;
            case 1:
                if (prevShot == 10) {
                    prevShot = curShot;
                    if (curShot == 10) {
                        display[frame] += "X";
                        shot++;
                    } else if (curShot == 0) {
                        display[frame] += "-";
                        shot++;
                    } else {
                        display[frame] += curShot;
                        shot++;
                    }
                } else {
                    if (prevShot + curShot == 10) {
                        display[frame] += "/";
                        shot++;
                    } else if (curShot == 0) {
                        display[frame] += "-";
                        frame++;
                    } else {
                        display[frame] += curShot;
                        frame++;
                    }
                }
                break;
            case 2:
                if (prevShot == 10) {
                    if (curShot == 0) {
                        display[frame] += "-";
                        frame++;
                    } else if (curShot == 10) {
                        display[frame] += "X";
                        frame++;
                    } else {
                        display[frame] += curShot;
                        frame++;
                    }
                } else {
                    if (prevShot + curShot == 10) {
                        display[frame] += "/";
                        frame++;
                    } else if (curShot == 0) {
                        display[frame] += "-";
                        frame++;
                    } else {
                        display[frame] += curShot;
                        frame++;
                    }
                }
                break;
            }
            index++;
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
