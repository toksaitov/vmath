package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMatrix4Created_thenMatrixIsIdentity() {
        Mat4 m = new Mat4();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(m.get(i,j), 1.0);
                } else {
                    assertEquals(m.get(i,j), 0.0);
                }
            }
        }
    }

    @Test
    void givenMatrix4_whenGetElementAtInvalidIndices_thenThrowException() {
        Mat4 m = new Mat4();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(4, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 4));
    }
}
