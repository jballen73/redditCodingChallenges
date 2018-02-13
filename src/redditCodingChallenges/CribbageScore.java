package redditCodingChallenges;
import java.util.stream.*;
import java.util.Arrays;
import java.util.List;
enum Suit{
    Spades,Hearts,Diamonds,Clubs
}
public class CribbageScore {

    public static void main(String[] args) {
        String[] cards = args[0].split(",");
        Integer[] vals = getVals(cards);
        List<Integer> valList = Arrays.asList(vals);
        int[] scores = valList.stream().mapToInt(x->Math.min(x,10)).toArray();
        Suit[] suits = getSuits(cards);
        int totalScore = 0;
        totalScore += 2 * findCombinations(15, scores);
        Integer[] sortedVals = Arrays.copyOf(vals, vals.length);
        Arrays.sort(sortedVals);
        totalScore += findRuns(sortedVals);
        totalScore += findFlushes(suits);
        totalScore += findNobs(vals, suits);
        System.out.println(totalScore);

    }
    private static Integer[] getVals(String[] cards) {
        Integer[] vals = new Integer[cards.length];
        for (int i = 0; i < cards.length; i++) {
            String num = cards[i].substring(0, cards[i].length() - 1);
            if (num.equals("K")) {
                vals[i] = 13;
            } else if (num.equals("Q")) {
                vals[i] = 12;
            } else if (num.equals("J")) {
                vals[i] = 11;
            } else if (num.equals("A")) {
                vals[i] = 1;
            } else {
                vals[i] = Integer.parseInt(num);
            }
        }
        return vals;
    }
    private static Suit[] getSuits(String[] cards) {
        Suit[] suits = new Suit[cards.length];
        for (int i = 0; i < cards.length; i++) {
            switch(cards[i].charAt(cards[i].length() - 1)) {
            case 'C':
                suits[i] = Suit.Clubs;
                break;
            case 'D':
                suits[i] = Suit.Diamonds;
                break;
            case 'H':
                suits[i] = Suit.Hearts;
                break;
            case 'S':
                suits[i] = Suit.Spades;
                break;
                default:
            }
        }
        return suits;
    }
    private static int[] removeIndex(int[] base, int index) {
        if (base.length == 1) {
            return new int[0];
        }
        int[] newArray = new int[base.length - 1];
        int newIndex = 0;
        for(int i = 0; i < base.length; i++) {
            if (i == index) {
                i++;
            }
            if (i < base.length) {
                newArray[newIndex] = base[i];
                newIndex++;
            }
        }
        return newArray;
    }
    private static int findCombinations(int target, int[] vals) {
        if (target == 0) {
            return 1;
        }
        if (vals.length == 0 || target < 0) {
            return 0;
        }
        int[] scores = vals;
        int total = 0;
        for (int i = 0; i < vals.length; i++) {
            total += findCombinations(target - scores[0], removeIndex(scores, 0));
            scores = removeIndex(scores,0);
        }
        return total;
    }
    private static int findRuns(Integer[] vals) {
        for (int i = 0; i < vals.length - 2; i++) {
            if (vals[i] + 1 == vals[i+1] && vals[i+1] + 1 == vals[i+2]) {
                if (i != vals.length - 3 && vals[i+2] + 1 == vals[i+3]) {
                    if (i != vals.length - 4 && vals[i+3] + 1== vals[i+4]) {
                        return 5;
                    } else {
                        return 4;
                    }
                } else {
                    return 3;
                }
            }
        }
        return 0;
    }
    private static int findFlushes(Suit[] suits) {
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3]) {
            if (suits[0] == suits[4]) {
                return 5;
            } else {
                return 4;
            }
        } else {
            return 0;
        }
    }
    private static int findNobs(Integer[] vals, Suit[] suits) {
        for (int i = 0; i < vals.length - 1; i++) {
            if (vals[i] == 11 && suits[i] == suits[4]) {
                return 1;
            }
        }
        return 0;
    }
}
