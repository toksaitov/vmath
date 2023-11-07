package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat2Test {

    @Test
    public void givenNoArgs_whenMat2Created_thenMatrixIsIdentity() {
        Mat2 matrix = new Mat2();

        assertEquals(1.0f, matrix.get(0, 0));
        assertEquals(0.0f, matrix.get(0, 1));
        assertEquals(0.0f, matrix.get(1, 0));
        assertEquals(1.0f, matrix.get(1, 1));
    }

    @Test
    void givenIdentityMatrix_whenGetElement_thenReturnValueMatches() {
        Mat2 matrix = new Mat2();

        assertEquals(1.0f, matrix.get(0, 0));
        assertEquals(0.0f, matrix.get(0, 1));
        assertEquals(0.0f, matrix.get(1, 0));
        assertEquals(1.0f, matrix.get(1, 1));
    }
}
