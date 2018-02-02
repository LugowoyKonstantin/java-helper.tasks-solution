package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 27-Jan-18.
 *
 * @author Konsytantin Lugowoy
 * @version 1.1
 *
 * The class is the root of the class hierarchy that implements the contract declared in the {@link FillingArrayOfPoints} interface
 * of the filling of objects of {@link Array} class and classical arrays with an object of the {@link Point} class
 * with numeric coordinates using the data read by the object of the class {@link Reader} encapsulated in this class.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */

public abstract class FillingArrayOfPointsWithCoordinatesReadValues<T extends Number> implements FillingArray<Point<T>> {

    private Reader reader;

    /**
     * Constructs a new heir class object,
     *  initializing an object of {@link Reader} class encapsulated in that class to read the data to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in this class to read data to fill array.
     */
    public FillingArrayOfPointsWithCoordinatesReadValues(Reader reader) {
        this.reader = reader;
    }

    /**
     * Constructs a new heir class object, initializing an object of {@link Reader} class
     *  encapsulated in that class of the concrete implementation of the contract declared in the interface {@link Reading}
     *  to read the data to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to initialize an object of the {@link Reader} class
     *                encapsulated in this class to read the data to be fill array.
     */
    public FillingArrayOfPointsWithCoordinatesReadValues(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    /**
     * Returns the {@link Reader} class object encapsulated in this class.
     *
     * @return The {@link Reader} class object encapsulated in this class.
     */
    Reader getReader() {
        return reader;
    }

}