package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMat4Created_thenMatrixIsIdentity() {
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
    void givenIdentityMatrix_whenMultipliedWithAnyMatrix_thenResultIsTheSame() {
        Mat4 identity = new Mat4(); 
        Mat4 someMatrix = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        Mat4 result = identity.mul(someMatrix);
        
        assertEquals(1.0f, result.get(0, 0));
        assertEquals(2.0f, result.get(0, 1));
        assertEquals(3.0f, result.get(0, 2));
        assertEquals(4.0f, result.get(0, 3));

        assertEquals(5.0f, result.get(1, 0));
        assertEquals(6.0f, result.get(1, 1));
        assertEquals(7.0f, result.get(1, 2));
        assertEquals(8.0f, result.get(1, 3));

        assertEquals(9.0f, result.get(2, 0));
        assertEquals(10.0f, result.get(2, 1));
        assertEquals(11.0f, result.get(2, 2));
        assertEquals(12.0f, result.get(2, 3));

        assertEquals(13.0f, result.get(3, 0));
        assertEquals(14.0f, result.get(3, 1));
        assertEquals(15.0f, result.get(3, 2));
        assertEquals(16.0f, result.get(3, 3));
    }

    @Test
    void givenTwoSpecificMatrices_whenMultiplied_thenResultIsAsExpected() {
        Mat4 matrixA = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        Mat4 matrixB = new Mat4(
            2.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 2.0f
        );

        Mat4 expected = new Mat4(
            2.0f, 4.0f, 6.0f, 8.0f,
            10.0f, 12.0f, 14.0f, 16.0f,
            18.0f, 20.0f, 22.0f, 24.0f,
            26.0f, 28.0f, 30.0f, 32.0f
        );

        Mat4 result = matrixA.mul(matrixB);

        assertEquals(expected.get(0, 0), result.get(0, 0));
        assertEquals(expected.get(0, 1), result.get(0, 1));
        assertEquals(expected.get(0, 2), result.get(0, 2));
        assertEquals(expected.get(0, 3), result.get(0, 3));

        assertEquals(expected.get(1, 0), result.get(1, 0));
        assertEquals(expected.get(1, 1), result.get(1, 1));
        assertEquals(expected.get(1, 2), result.get(1, 2));
        assertEquals(expected.get(1, 3), result.get(1, 3));

        assertEquals(expected.get(2, 0), result.get(2, 0));
        assertEquals(expected.get(2, 1), result.get(2, 1));
        assertEquals(expected.get(2, 2), result.get(2, 2));
        assertEquals(expected.get(2, 3), result.get(2, 3));

        assertEquals(expected.get(3, 0), result.get(3, 0));
        assertEquals(expected.get(3, 1), result.get(3, 1));
        assertEquals(expected.get(3, 2), result.get(3, 2));
        assertEquals(expected.get(3, 3), result.get(3, 3));
    }

    @Test
    void givenMatricesFromFloatArray_whenMultiplied_thenResultIsAsExpected() {
        float[] valuesA = {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };

        float[] valuesB = {
            2.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 2.0f
        };

        Mat4 matrixA = new Mat4(valuesA);
        Mat4 matrixB = new Mat4(valuesB);

        Mat4 expected = new Mat4(
            2.0f, 4.0f, 6.0f, 8.0f,
            10.0f, 12.0f, 14.0f, 16.0f,
            18.0f, 20.0f, 22.0f, 24.0f,
            26.0f, 28.0f, 30.0f, 32.0f
        );

        Mat4 result = matrixA.mul(matrixB);

        assertEquals(expected.get(0, 0), result.get(0, 0));
        assertEquals(expected.get(0, 1), result.get(0, 1));
        assertEquals(expected.get(0, 2), result.get(0, 2));
        assertEquals(expected.get(0, 3), result.get(0, 3));

        assertEquals(expected.get(1, 0), result.get(1, 0));
        assertEquals(expected.get(1, 1), result.get(1, 1));
        assertEquals(expected.get(1, 2), result.get(1, 2));
        assertEquals(expected.get(1, 3), result.get(1, 3));

        assertEquals(expected.get(2, 0), result.get(2, 0));
        assertEquals(expected.get(2, 1), result.get(2, 1));
        assertEquals(expected.get(2, 2), result.get(2, 2));
        assertEquals(expected.get(2, 3), result.get(2, 3));

        assertEquals(expected.get(3, 0), result.get(3, 0));
        assertEquals(expected.get(3, 1), result.get(3, 1));
        assertEquals(expected.get(3, 2), result.get(3, 2));
        assertEquals(expected.get(3, 3), result.get(3, 3));
    }
}