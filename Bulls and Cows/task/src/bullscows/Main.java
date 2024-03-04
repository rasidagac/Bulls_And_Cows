package bullscows;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static String secretCode;
    static final int MAX_SECRET_CODE_LENGTH = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secretCodeLength = scanner.nextInt();

        checkSecretCodeLength(secretCodeLength);
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

    static void findBullsAndCows(String guess) {
        String secretCode = getSecretCode();

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
            System.out.println("Grade: None.");
        } else if (bulls == 0) {
            System.out.println("Grade: " + cows + " cow" + (cows > 1 ? "s" : ""));
        } else if (cows == 0) {
            System.out.println("Grade: " + bulls + " bull" + (bulls > 1 ? "s" : ""));
        } else {
            System.out.println("Grade: " + bulls + " bull" + (bulls > 1 ? "s" : "") + " and " + cows + " cow" + (cows > 1 ? "s" : ""));
        }
    }

    static void checkSecretCodeLength(int length) {
        if (length > MAX_SECRET_CODE_LENGTH) {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
        } else {
            setSecretCode(generateSecretCode(length));
            System.out.println("Okay, let's start a game!");
            guessSecretCode();
        }
    }

    static void guessSecretCode() {
        Scanner scanner = new Scanner(System.in);
        String guess;
        int turn = 1;

        do {
            System.out.println("Turn " + turn + ":");
            guess = scanner.nextLine();
            findBullsAndCows(guess);
            turn++;
        } while (!Objects.equals(guess, getSecretCode()));

        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static String getSecretCode() {
        return secretCode;
    }

    public static void setSecretCode(String secretCode) {
        Main.secretCode = secretCode;
    }
}
