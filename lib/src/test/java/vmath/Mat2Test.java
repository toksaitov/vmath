package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat2Test {

    @Test
    void givenNoArgs_whenMat2Created_thenMatrixIsIdentity() {
        var m = new Mat2();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
    }

    @Test
    void givenArgs_whenMat2Created_thenMatrixHasGivenValues() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenNaNValues_whenMat2Created_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> new Mat2(
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN
        ));

        assertThrows(ArithmeticException.class, () -> new Mat2(
            1.0f, 2.0f,
            3.0f, Float.NaN
        ));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenInvalidIndices_whenGetIsCalled_thenThrowsException() {
        var m = new Mat2();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(2, 0));

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 2));
    }
}
