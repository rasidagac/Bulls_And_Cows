package bullscows;

public class Main {
    public static void main(String[] args) {
        ISecretCodeGenerator secretCodeGenerator = new SecretCodeGenerator();
        Game game = new Game(secretCodeGenerator);
        game.start();
    }
}