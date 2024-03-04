package bullscows;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    private final ISecretCodeGenerator secretCodeGenerator;
    private String secretCode;

    public Game(ISecretCodeGenerator secretCodeGenerator) {
        this.secretCodeGenerator = secretCodeGenerator;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String secretCodeLength = scanner.nextLine();

        if (!secretCodeLength.matches("\\d+") || Integer.parseInt(secretCodeLength) < 1 || Integer.parseInt(secretCodeLength) > SecretCodeGenerator.MAX_SECRET_CODE_LENGTH) {
            System.out.println("Error: \"" + secretCodeLength + "\" isn't a valid number.");
        } else {
            System.out.println("Input the number of possible symbols in the code:");
            int possibleSymbols = scanner.nextInt();
            checkSecretCode(Integer.parseInt(secretCodeLength), possibleSymbols);
        }
    }

    private void checkSecretCode(int length, int possibleSymbols) {
        if (possibleSymbols > SecretCodeGenerator.MAX_SECRET_CODE_LENGTH) {
            System.out.println("Error: maximum number of possible symbols in the code is " + SecretCodeGenerator.MAX_SECRET_CODE_LENGTH + " (0-9, a-z).");
        } else {
            if (length > possibleSymbols) {
                System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + possibleSymbols + " unique symbols.");
            } else {
                secretCode = secretCodeGenerator.generateSecretCode(length, possibleSymbols);
                String stringWillPrinted = possibleSymbols < 11 ? "0-" + (possibleSymbols - 1) : "0-9, a-" + SecretCodeGenerator.possibleSymbolsString.charAt(possibleSymbols - 1);
                System.out.println("The secret is prepared: " + "*".repeat(length) + " " + "(" + stringWillPrinted + ")");
                System.out.println("Okay, let's start a game!");
                guessSecretCode();
            }
        }
    }

    private void guessSecretCode() {
        Scanner scanner = new Scanner(System.in);
        String guess;
        int turn = 1;

        do {
            System.out.println("Turn " + turn + ":");
            guess = scanner.nextLine();
            int[] result = GuessValidator.findBullsAndCows(guess, secretCode);
            GamePrinter.printGrade(result[0], result[1]);
            turn++;
        } while (!Objects.equals(guess, secretCode));

        System.out.println("Congratulations! You guessed the secret code.");
    }
}