package vmath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Mat3Test {

    @Test
    void givenNoArgs_whenMat3Created_thenMatrixIsIdentity() {
        var m = new Mat3();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);
        assertEquals(m.get(0, 2), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
        assertEquals(m.get(1, 2), 0.0f);

        assertEquals(m.get(2, 0), 0.0f);
        assertEquals(m.get(2, 1), 0.0f);
        assertEquals(m.get(2, 2), 1.0f);
    }

    @Test
    void givenArrayArg_whenMat3Created_thenMatrixHasGivenValues() {
        var a = new float[] {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        };
        var m = new Mat3(a);

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
    void givenNullArray_whenMat3Created_thenThrowsException() {
        float[] a = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat3(a));
    }

    @Test
    void givenArrayOfInvalidLength_whenMat3Created_thenThrowsException() {
        var a1 = new float[] {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat3(a1));

        var a2 = new float[] {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f, 10.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat3(a2));
    }

    @Test
    void givenArrayWithNaNs_whenMat3Created_thenThrowsException() {
        float[] a1 = {
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat3(a1));

        float[] a2 = {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat3(a2));
    }
}
