package vmath;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Mat3Test {

    @Test
    void givenNoArgs_whenMat3Created_thenMatrixIsIdentity() {
        var m1 = new Mat3();

        assertEquals(1.0f, m1.get(0, 0));
        assertEquals(0.0f, m1.get(0, 1));
        assertEquals(0.0f, m1.get(0, 2));
        assertEquals(0.0f, m1.get(1, 0));
        assertEquals(1.0f, m1.get(1, 1));
        assertEquals(0.0f, m1.get(1, 2));
        assertEquals(0.0f, m1.get(2, 0));
        assertEquals(0.0f, m1.get(2, 1));
        assertEquals(1.0f, m1.get(2, 2));
    }

    @Test
    void givenArrArg_whenMat3Created_thenMatrixHasGivenValues() {
        var arr = new float[] {
                1.0f,  2.0f,  3.0f,
                4.0f,  5.0f,  6.0f,
                7.0f,  8.0f,  9.0f
        };
        var m = new Mat3(arr);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);

        assertEquals(m.get(1, 0), 4.0f);
        assertEquals(m.get(1, 1), 5.0f);
        assertEquals(m.get(1, 2), 6.0f);

        assertEquals(m.get(2, 0), 7.0f);
        assertEquals(m.get(2, 1), 8.0f);
        assertEquals(m.get(2, 2), 9.0f);
    }

    @Test
    void givenWrongArrSize_whenMat3Created_thenThrowsException() {
        var arr = new float[]{
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f, 0.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat3(arr));
    }

    @Test
    void givenNaNValuesInArr_whenMat3Created_thenThrowsException() {
        for (int i = 0; i < 9; i++) {
            var arr = new float[9];
            arr[i] = Float.NaN;
            assertThrows(ArithmeticException.class, () -> new Mat3(arr));
        }
    }

    @Test
    void givenNullArr_whenMat3Created_thenThrowsException() {
        float[] arr = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat3(arr));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        //TODO
    }

    @Test
    void givenInvalidIndices_whenGetCalled_thenThrowIndexOutOfBoundsException() {
        var m1 = new Mat3();

        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(3, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(0, 3));
    }
}