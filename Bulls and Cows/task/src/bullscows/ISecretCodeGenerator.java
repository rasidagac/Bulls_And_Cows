package bullscows;

public interface ISecretCodeGenerator {
    String generateSecretCode(int length, int possibleSymbols);
}
