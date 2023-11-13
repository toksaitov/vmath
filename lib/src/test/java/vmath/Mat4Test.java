package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMat4Created_thenMatrixIsIdentity() {
        Mat4 m = new Mat4();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(m.get(i, j), 1.0f);
                } else {
                    assertEquals(m.get(i, j), 0.0f);
                }
            }
        }
        var m = new Mat4();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);
        assertEquals(m.get(0, 2), 0.0f);
        assertEquals(m.get(0, 3), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
        assertEquals(m.get(1, 2), 0.0f);
        assertEquals(m.get(1, 3), 0.0f);

        assertEquals(m.get(2, 0), 0.0f);
        assertEquals(m.get(2, 1), 0.0f);
        assertEquals(m.get(2, 2), 1.0f);
        assertEquals(m.get(2, 3), 0.0f);

        assertEquals(m.get(3, 0), 0.0f);
        assertEquals(m.get(3, 1), 0.0f);
        assertEquals(m.get(3, 2), 0.0f);
        assertEquals(m.get(3, 3), 1.0f);
    }

    @Test
    void givenArgs_whenMat4Created_thenMatrixHasGivenValues() {
        var m = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void givenNaNValues_whenMat4Created_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> new Mat4(
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN
        ));

        assertThrows(ArithmeticException.class, () -> new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, Float.NaN
        ));
    }

    @Test
    void givenArrayArg_whenMat4Created_thenMatrixHasGivenValues() {
        var a = new float[] {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };
        var m = new Mat4(a);
      
        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void givenNullArray_whenMat4Created_thenThrowsException() {
        float[] a = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat4(a));
    }

    @Test
    void givenArrayOfInvalidLength_whenMat4Created_thenThrowsException() {
        var a1 = new float[] {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat4(a1));

        var a2 = new float[] {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f, 17.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat4(a2));
    }

    @Test
    void givenArrayWithNaNs_whenMat4Created_thenThrowsException() {
        float[] a1 = {
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat4(a1));

        float[] a2 = {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat4(a2));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        var m = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void givenInvalidIndices_whenGetIsCalled_thenThrowsException() {
        var m = new Mat4();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(4, 0));

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 4));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        //TODO
    }

    @Test
    void givenInvalidIndices_whenGetCalled_thenThrowIndexOutOfBoundsException() {
        Mat4 m = new Mat4();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(4, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 4));
    }
}