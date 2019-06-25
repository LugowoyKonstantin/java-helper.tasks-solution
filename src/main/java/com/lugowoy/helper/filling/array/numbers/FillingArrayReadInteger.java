package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;

/**
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with data of the {@link Integer} type with read by the {@link Reader} class object
 * encapsulated in the parent class {@link FillingArrayReadValues}.
 * The class is the heir of the FillingArrayReadValues class and implements its contract.
 * Also implements the contract announced by the FillingArrayNumbers interface.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayReadInteger extends FillingArrayReadValues<Integer> implements FillingArrayNumbers<Integer> {

    /**
     * Constructs a new object of {@link FillingArrayReadInteger} class,
     * initializing an object of {@link Reader} class
     * encapsulated in the parent class to read data of the {@link Integer} type to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in the parent class to read data of the {@link Integer} type to fill the array.
     */
    public FillingArrayReadInteger(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object of {@link FillingArrayReadInteger} class,
     * initializing an object of {@link Reader} class
     * encapsulated in the parent class of the concrete implementation of the contract declared in the interface {@link Reading}
     * to read data of the {@link Integer} type to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface
     *                to initialize an object of the {@link Reader} class encapsulated in the parent class
     *                to read data of the {@link Integer} type to be fill array.
     */
    public FillingArrayReadInteger(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Integer} type
     * with read by the {@link Reader} class object.
     *
     * @param array The object of the {@link Array} class to be filled with data of the {@link Integer} type
     *              with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If object argument is null.
     */
    @Override
    public void fill(Array<Integer> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayElementsEnteredIntegerNumbers(integers);
            array.setArray(integers);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     *
     * @param integers The array to be filled with data of the {@link Integer} type
     *                 with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            this.fillArrayElementsEnteredIntegerNumbers(integers);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Integer} type
     *                    with read by the {@link Reader} class object.
     * @return Created and filled array with data of the {@link Integer} type with read by the {@link Reader} class object.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayElementsEnteredIntegerNumbers(integers);
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayElementsEnteredIntegerNumbers(integers);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Integer} type with read by the {@link Reader} class object.
     * <p>The object of the {@link Array} class is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled with data of the {@link Integer} type
     *              with read by the {@link Reader} class object.
     * @param bound The value of the bound for filling an object of the {@link Array} class with data of the {@link Integer} type
     *              with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, bound);
                array.setArray(integers);
            } else {
                this.fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
                array.setArray(integers);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     * <p>The array is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}.
     *
     * @param integers The array to be filled with data of the {@link Integer} type with read by the {@link Reader} class object.
     * @param bound    The value of the end bound for filling an array with data of the {@link Integer} type
     *                 with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from 0 to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Integer} type
     *                    with read by the {@link Reader} class object.
     * @param bound       The value of the border for filling the array with data of the {@link Integer} type
     *                    with read by the {@link Reader} class object.
     * @return Created and filled an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isPositiveBoundValueAndNonNull(bound)) {
                this.fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, bound);
            } else {
                this.fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(integers, POSITIVE_INTEGER_BOUND);
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Integer} type with read by the {@link Reader} class object.
     * <p>The object of the {@link Array} class is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class to be filled with data of the {@link Integer} type
     *                   with read by the {@link Reader} class object.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class with data of the {@link Integer} type
     *                   with read by the {@link Reader} class object.
     * @param endBound   The value of the end bound for filling an object of the {@link Array} class with
     *                   data of the {@link Integer} type with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Integer> array, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
                array.setArray(integers);
            } else {
                this.fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers,
                        NEGATIVE_INTEGER_BOUND,
                        POSITIVE_INTEGER_BOUND);
                array.setArray(integers);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     * <p>The array is filled with numeric data from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param integers   The array to be filled with data of the {@link Integer} type with read by the {@link Reader} class object.
     * @param startBound The value of the start bound for filling an array with data of the {@link Integer} type
     *                   with read by the {@link Reader} class object.
     * @param endBound   The value of the end bound for filling an array with data of the {@link Integer} type
     *                   with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Integer[] integers, Integer startBound, Integer endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (CheckerFillingArray.checkNonNullArray(integers)) {
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers,
                        NEGATIVE_INTEGER_BOUND,
                        POSITIVE_INTEGER_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_INTEGER_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_INTEGER_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Integer} type
     *                    with read by the {@link Reader} class object.
     * @param startBound  The value of the start bound for filling an array with data of the {@link Integer} type
     *                    with read by the {@link Reader} class object.
     * @param endBound    The value of the end bound for filling an array with data of the {@link Integer} type
     *                    with read by the {@link Reader} class object.
     * @return Created and filled an array with data of the {@link Integer} type with read by the {@link Reader} class object.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer startBound, Integer endBound) {
        //todo check or add relevant checks.
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (isCorrectRangeBoundValue(startBound) && isCorrectRangeBoundValue(endBound))) {
                this.fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers, startBound, endBound);
            } else {
                this.fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers,
                        NEGATIVE_INTEGER_BOUND,
                        POSITIVE_INTEGER_BOUND);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH];
            this.fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(integers,
                    NEGATIVE_INTEGER_BOUND,
                    POSITIVE_INTEGER_BOUND);
        }
        return integers;
    }

    private void fillArrayElementsEnteredIntegerNumbers(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = super.getReader().readInt();
        }
    }

    private void fillArrayElementsEnteredIntegerNumbersFromZeroToPositiveBound(Integer[] integers, int bound) {
        int value;
        for (int i = 0; i < integers.length; i++) {
            //todo fix to re-enter.
            value = super.getReader().readInt();
            if ((value >= START_BOUND) && (value <= bound)) {
                integers[i] = value;
            } else {
                integers[i] = INTEGER_VALUE;
            }
        }
    }

    private void fillArrayElementsEnteredIntegerNumbersFromStartBoundToEndBound(Integer[] integers, int startBound, int endBound) {
        int value;
        for (int i = 0; i < integers.length; i++) {
            //todo fix to re-enter.
            value = super.getReader().readInt();
            if ((value >= startBound) && (value <= endBound)) {
                value = super.getReader().readInt();
                if ((value >= startBound) && (value <= endBound)) {
                    integers[i] = value;
                } else {
                    integers[i] = INTEGER_VALUE;
                }
            }
        }
    }

}