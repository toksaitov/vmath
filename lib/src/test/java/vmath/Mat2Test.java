package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat2Test {

    @Test
    void givenNoArgs_whenMat2Created_thenMatrixIsIdentity() {
        Mat2 matrix = new Mat2();

        assertEquals(1.0f, matrix.get(0, 0));
        assertEquals(0.0f, matrix.get(0, 1));
        assertEquals(0.0f, matrix.get(1, 0));
        assertEquals(1.0f, matrix.get(1, 1));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnValueMatches() {
        //TODO
    }

    @Test
    void givenArgs_whenMat2Created_thenMatrixHasGivenValues() {
        float[] m = {
            2.0f, 3.0f,
            4.0f, 5.0f
        };

        Mat2 mat2 = new Mat2(m);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(m[i * 2 + j], mat2.get(i, j));
            }
        }
    }

    @Test
    void givenArrayOfInvalidLength_whenMat2Created_thenThrowsException() {
        float[] invalidSize = {
            2.0f, 3.0f,
            4.0f
        };

        assertThrows(IllegalArgumentException.class, () -> new Mat2(invalidSize));
    }

    @Test
    void givenNaNValues_whenMat2Created_thenThrowsException() {
        float[] invalidValuesWithAllNaN = {
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN
        };

        assertThrows(IllegalArgumentException.class, () -> new Mat2(invalidValuesWithAllNaN));

        float[] invalidValuesWithOneNaN = {
            1.0f, 2.0f,
            Float.NaN, 3.0f
        };

        assertThrows(IllegalArgumentException.class, () -> new Mat2(invalidValuesWithOneNaN));
    }

    @Test
    void givenNullArray_whenMat3Created_thenThrowsException() {
        float[] arr = null;

        assertThrows(IllegalArgumentException.class, () -> new Mat2(arr));
    }

    @Test
    void givenInvalidIndices_whenGetCalled_thenThrowIndexOutOfBoundsException() {
        Mat2 matrix = new Mat2();

        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(3, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(0, 3));
    }
}
