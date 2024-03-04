package bullscows;

public class SecretCodeGenerator implements ISecretCodeGenerator {
    static final String possibleSymbolsString = "0123456789abcdefghijklmnopqrstuvwxyz";
    static final int MAX_SECRET_CODE_LENGTH = 36;

    @Override
    public String generateSecretCode(int length, int possibleSymbols) {
        StringBuilder secretCode = new StringBuilder();
        String allowedSubstring = possibleSymbolsString.substring(0, possibleSymbols);
        while (secretCode.length() < length) {
            char digit = allowedSubstring.charAt((int) (Math.random() * possibleSymbols));
            if (secretCode.indexOf(String.valueOf(digit)) == -1) {
                secretCode.append(digit);
            }
        }
        return secretCode.toString();
    }
}
