package bullscows;

public class GuessValidator {
    public static int[] findBullsAndCows(String guess, String secretCode) {
        int cows = 0;
        int bulls = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            char digit = guess.charAt(i);
            if (digit == secretCode.charAt(i)) {
                bulls++;
            } else if (secretCode.indexOf(digit) != -1) {
                cows++;
            }
        }
        return new int[]{bulls, cows};
    }
}