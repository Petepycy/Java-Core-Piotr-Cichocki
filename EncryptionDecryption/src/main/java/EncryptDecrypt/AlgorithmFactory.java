package EncryptDecrypt;

public class AlgorithmFactory {
    public static Algorithm getAlgorithm(String algorithm) {
        return switch (algorithm) {
            case "shift" -> new Shift();
            case "unicode" -> new Unicode();
            default -> null;
        };
    }
}