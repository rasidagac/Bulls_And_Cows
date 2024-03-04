package bullscows;

import java.util.Scanner;

public class Main {
    static String secretCode = "";
    static final int MAX_SECRET_CODE_LENGTH = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secretCodeLength = scanner.nextInt();

        if (secretCodeLength > MAX_SECRET_CODE_LENGTH) {
            System.out.println("Error: can't generate a secret number with a length of " + secretCodeLength + " because there aren't enough unique digits.");
        } else {
            secretCode = generateSecretCode(secretCodeLength);
            System.out.println("The random secret number is " + secretCode + ".");
        }
//        do {
//            findBullsAndCows(secretCode, guess);
//            guess = scanner.nextLine();
//        } while (!Objects.equals(guess, secretCode));

    }

    static String generateSecretCode(int length) {
        StringBuilder secretCode = new StringBuilder();
        while (secretCode.length() < length) {
            char digit = (char) (Math.random() * 10 + '0');
            if (secretCode.indexOf(String.valueOf(digit)) == -1) {
                secretCode.append(digit);
            }
        }

        return secretCode.toString();
    }

    static void findBullsAndCows(String secretCode, String guess) {
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
        if (bulls == 0 && cows == 0) {
            System.out.println("None. The secret code is " + secretCode);
        } else if (bulls == 0) {
            System.out.println("Grade: " + cows + " cow(s). The secret code is " + secretCode);
        } else if (cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s). The secret code is " + secretCode);
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secretCode);
        }
    }
}
