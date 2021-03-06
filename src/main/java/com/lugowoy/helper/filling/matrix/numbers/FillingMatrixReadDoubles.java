package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.math.BigDecimal;

/**
 * <p>Created by Konstantin Lugowoy on 10.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.matrix.FillingMatrixReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.matrix.FillingMatrix
 * @see com.lugowoy.helper.filling.matrix.numbers.FillingMatrixNumbers
 * @since 1.2
 */
//TODO write documentation
public class FillingMatrixReadDoubles extends FillingMatrixReadValues
        implements FillingMatrixNumbers<Double> {

    public FillingMatrixReadDoubles(final @NotNull Reader reader) {
        super(reader);
    }

    @Override
    public void fill(@NotNull final Matrix<Double> matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(doubles);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final Double[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.fillMatrix(matrix);
    }

    @Override
    public Double[][] fill(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrix(matrix);
        return matrix;
    }

    @Override
    public void fill(@NotNull final Matrix<Double> matrix,
                     @NotNull final Double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(doubles, bound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final Double[][] matrix,
                     @NotNull final Double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    @Override
    public Double[][] fill(final int rows, final int columns,
                           @NotNull final Double bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkRows(columns, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        Double[][] matrix = new Double[rows][columns];
        this.fillMatrixFromZeroToBound(matrix, bound);
        return matrix;
    }

    @Override
    public void fill(@NotNull final Matrix<Double> matrix,
                     @NotNull final Double lowerBound,
                     @NotNull final Double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final Double[][] matrix,
                     @NotNull final Double lowerBound,
                     @NotNull final Double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillMatrixFromLowerToUpper(matrix, lowerBound, upperBound);
    }

    @Override
    public Double[][] fill(final int rows, final int columns,
                           @NotNull final Double lowerBound,
                           @NotNull final Double upperBound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Double[][] doubles = new Double[rows][columns];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillMatrix(final Double[][] matrix) {
        this.fillMatrixFromLowerToUpper(matrix, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
    }

    private void fillMatrixFromZeroToBound(final Double[][] matrix,
                                           final Double bound) {
        this.fillMatrixFromLowerToUpper(matrix, BigDecimal.ZERO.doubleValue(),
                                        bound);
    }

    private void fillMatrixFromLowerToUpper(final Double[][] matrix,
                                            final Double lowerBound,
                                            final Double upperBound) {
        double valueRead = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (super.getReader().hasNextDouble()) {
                    valueRead = super.getReader().nextDouble();
                    CheckerNumber.check(valueRead, lowerBound, upperBound);
                }
                matrix[i][j] = valueRead;
            }
        }
    }

}
