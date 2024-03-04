package bullscows;

public class GamePrinter {
    public static void printGrade(int bulls, int cows) {
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
}