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

    @Test
    void givenFloatArray_whenMat4Created_thenMatrixMatchesArray() {
        float[] mat = {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };

        Mat4 m = new Mat4(mat);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(m.get(i, j), mat[i * 4 + j]);
            }
        }
    }
}
