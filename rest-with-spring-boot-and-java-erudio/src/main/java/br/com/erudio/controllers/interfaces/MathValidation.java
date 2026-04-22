package br.com.erudio.controllers.interfaces;

public interface MathValidation {

    default boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    default Double convertToDouble(String str) {
        return Double.parseDouble(str);
    }

    default void validateNumbers(String... values) {
        for (String v : values) {
            if (!isNumeric(v)) {
                throw new IllegalArgumentException("Please set a numeric value!");
            }
        }
    }
}
