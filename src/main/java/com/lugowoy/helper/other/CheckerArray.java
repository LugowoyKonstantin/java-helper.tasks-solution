package com.lugowoy.helper.other;

import com.lugowoy.helper.models.Array;

/**
 * Interface that performs static functions to perform checks on the correctness of various values associated with arrays.
 * <p>Created by Konstantin Lugowoy on ... .
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.2
 */
public interface CheckerArray {

    /**
     * Returns the result of the check object of the Array class passed by argument to is a null.
     * @param array The object of the Array class to check.
     * @return Result of the check.
     */
    static <T> boolean checkArrayNonNull(Array<T> array) {
        boolean result = false;
        if (array != null) {
            result = true;
        }
        return result;
    }

    /**
     * Returns the result of the check array passed by argument to is a null.     *
     * @param array The array to check.
     * @return Result to check.
     */
    static <T> boolean checkArrayNonNull(T[] array) {
        boolean result = false;
        if (array != null) {
            result = true;
        }
        return result;
    }

    /**
     * Returns the result of the check value of the length of the array passed by argument is equal to or greater than zero.
     * @param lengthOfArray The value of the length of the array.
     * @return Result to check.
     */
    static boolean checkLengthOfArrayIsEqualToOrGreaterThanZero(int lengthOfArray) {
        boolean result = false;
        if (lengthOfArray >= 0) {
            result = true;
        }
        return result;
    }

    /**
     * Returns the result of the check value of the length of the array passed by argument is greater than zero.
     * @param lengthOfArray The value of the length of the array.
     * @return Result to check.
     */
    static boolean checkLengthOfArrayIsGreaterZero(int lengthOfArray) {
        boolean result = false;
        if (lengthOfArray > 0) {
            result = true;
        }
        return result;
    }

}