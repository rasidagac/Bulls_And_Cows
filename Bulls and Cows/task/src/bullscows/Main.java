package bullscows;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = String.valueOf(3536);
        String guess = scanner.nextLine();

        do {
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
            guess = scanner.nextLine();
        } while (!Objects.equals(guess, secretCode));

    }

}
