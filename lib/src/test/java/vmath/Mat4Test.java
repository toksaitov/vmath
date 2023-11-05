package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMatrix4Created_thenMatrixIsIdentity() {
        Mat4 m = new Mat4();

        assertEquals(m.get(3,2), 0.0);
        assertEquals(m.get(0,0), 1.0);
        assertEquals(m.get(3,3), 1.0);
    }

    @Test
    void givenMatrix4_whenGetElementAtInvalidIndices_thenThrowException() {
        Mat4 m = new Mat4();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(4, 3));
    }
}
