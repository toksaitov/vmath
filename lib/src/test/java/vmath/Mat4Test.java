package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMatrix4Created_thenMatrixIsIdentity() {
        var newMatrix = new Mat4();

        assertEquals(newMatrix.m[0], 1.0f);
        assertEquals(newMatrix.m[1], 0.0f);
        assertEquals(newMatrix.m[2], 0.0f);
        assertEquals(newMatrix.m[3], 0.0f);

        assertEquals(newMatrix.m[4], 0.0f);
        assertEquals(newMatrix.m[5], 1.0f);
        assertEquals(newMatrix.m[6], 0.0f);
        assertEquals(newMatrix.m[7], 0.0f);

        assertEquals(newMatrix.m[8], 0.0f);
        assertEquals(newMatrix.m[9], 0.0f);
        assertEquals(newMatrix.m[10], 1.0f);
        assertEquals(newMatrix.m[11], 0.0f);

        assertEquals(newMatrix.m[12], 0.0f);
        assertEquals(newMatrix.m[13], 0.0f);
        assertEquals(newMatrix.m[14], 0.0f);
        assertEquals(newMatrix.m[15], 1.0f);

    }
}
