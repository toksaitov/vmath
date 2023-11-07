package vmath;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Mat3Test {

    @Test
    void givenNoArgs_whenMat3Created_thenMatrixIsIdentity() {
        var m1 = new Mat3();

        assertEquals(1.0f, m1.get(0, 0));
        assertEquals(0.0f, m1.get(0, 1));
        assertEquals(0.0f, m1.get(0, 2));
        assertEquals(0.0f, m1.get(1, 0));
        assertEquals(1.0f, m1.get(1, 1));
        assertEquals(0.0f, m1.get(1, 2));
        assertEquals(0.0f, m1.get(2, 0));
        assertEquals(0.0f, m1.get(2, 1));
        assertEquals(1.0f, m1.get(2, 2));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        //TODO
    }

    @Test
    void givenInvalidIndices_whenGetCalled_thenThrowIndexOutOfBoundsException() {
        var m1 = new Mat3();

        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(3, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m1.get(0, 3));
    }
}