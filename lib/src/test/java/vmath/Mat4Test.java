package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMatrix4Created_thenMatrixIsIdentity() {
        var m = new Mat4();

        float[] values = {
                1.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 1.0f
        };

        assertArrayEquals(values, m.mat(), 0.001f);
    }

    @Test
    public void givenArgs_whenMatrix4Created_thenMatrixHasGivenValues() {
        float[] values = {
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f
        };

        var m = new Mat4(values);

        assertArrayEquals(values, m.mat(), 0.001f);
    }

    @Test
    void givenNotFullInputArray_whenMatrix4Created_thenExceptionThrown() {
        float[] invalidValues = {
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f
        };

        assertThrows(IllegalArgumentException.class, () -> new Mat4(invalidValues));
    }

    @Test
    void givenNaNValues_whenMatrix4Created_thenThrowsException() {
        float[] valuesWithNaN = {
                Float.NaN, Float.NaN, Float.NaN, Float.NaN,
                Float.NaN, Float.NaN, Float.NaN, Float.NaN,
                Float.NaN, Float.NaN, Float.NaN, Float.NaN,
                Float.NaN, Float.NaN, Float.NaN, Float.NaN
        };

        assertThrows(ArithmeticException.class, () -> new Mat4(valuesWithNaN));
    }
}
