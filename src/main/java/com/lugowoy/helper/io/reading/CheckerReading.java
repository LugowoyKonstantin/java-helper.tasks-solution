package com.lugowoy.helper.io.reading;

/**
 * Functional interface that performs the function of checking the read data for correctness.
 * <p>Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 */
@FunctionalInterface
public interface CheckerReading {

    /**
     * A string constant that defines a regular expression for a positive integer number.
     *
     * @since 1.0
     */
    String REGEX_POSITIVE_INTEGER_NUMBER = "\\d+?";

    /**
     * A string constant that defines a regular expression for a negative integer number.
     *
     * @since 1.0
     */
    String REGEX_NEGATIVE_INTEGER_NUMBER = "-\\d+?";

    /**
     * A string constant that defines a regular expression for a negative real number.
     *
     * @since 1.0
     */
    String REGEX_POSITIVE_REAL_NUMBER = "\\d+?[.]\\d+?";

    /**
     * A string constant that defines a regular expression for a negative real number.
     *
     * @since 1.0
     */
    String REGEX_NEGATIVE_REAL_NUMBER = "-\\d+?[.]\\d+?";

    /**
     * Function that checks the read data for correctness.
     *
     * @param value Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    boolean isCorrect(final String value);

    /**
     * A static method that check that the read data is indeed an integer number and is included in a range of byte type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isByteNumber(final String numberValue) {
        boolean result = false;
        if ((numberValue != null)) {
            if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
                if ((Byte.parseByte(numberValue) >= (Byte.MIN_VALUE + 1)) && (Byte.parseByte(numberValue) <= (Byte.MAX_VALUE - 1))) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed an integer number and is included in a range of short type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isShortNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
                if ((Short.parseShort(numberValue) >= (Short.MIN_VALUE + 1)) && (Short.parseShort(numberValue) <= (Short.MAX_VALUE - 1))) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed an integer number and is included in a range of integer type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isIntegerNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
                if ((Integer.parseInt(numberValue) >= (Integer.MIN_VALUE + 1)) && (Integer.parseInt(numberValue) <= (Integer.MAX_VALUE - 1))) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed an integer number and is included in a range of long type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isLongNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER) || numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)) {
                if ((Long.parseLong(numberValue) >= (Long.MIN_VALUE + 1)) && (Long.parseLong(numberValue) <= (Long.MAX_VALUE - 1))) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed a real number and is included in a range of float type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isFloatNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (((numberValue.matches(REGEX_POSITIVE_REAL_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_REAL_NUMBER)))
                    || ((numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)))) {
                if ((Float.parseFloat(numberValue) >= Float.MIN_VALUE) || (Float.parseFloat(numberValue) <= Float.MAX_VALUE)) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that check that the read data is indeed a real number and is included in a range of double type values.
     *
     * @param numberValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isDoubleNumber(final String numberValue) {
        boolean result = false;
        if (numberValue != null) {
            if (((numberValue.matches(REGEX_POSITIVE_REAL_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_REAL_NUMBER)))
                    || ((numberValue.matches(REGEX_POSITIVE_INTEGER_NUMBER)) || (numberValue.matches(REGEX_NEGATIVE_INTEGER_NUMBER)))) {
                if ((Double.parseDouble(numberValue) >= Double.MIN_VALUE) || (Double.parseDouble(numberValue) <= Double.MAX_VALUE)) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * A static method that verifies that the read data is indeed a single character.
     *
     * @param characterValue Data to check.
     * @return Result of checking.
     *
     * @since 1.0
     */
    static boolean isOnlyCharacter(final String characterValue) {
        boolean result = false;
        if (characterValue != null) {
            if (characterValue.length() == 1) {
                if (Character.isDefined(characterValue.charAt(0))) {
                    result = true;
                }
            }
        }
        return result;
    }

}