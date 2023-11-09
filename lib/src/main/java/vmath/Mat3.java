
package vmath;

public class Mat3 {
    private final float[] m;

    public Mat3() {
        m = new float[] {
            1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 1.0f};
    }

    public Mat3(float[] arr) {
        if (arr == null || arr.length != 9) {
            throw new IllegalArgumentException();
        }
        for (float val : arr) {
            if (Float.isNaN(val)) {
                throw new ArithmeticException();
            }
        }
        m = arr.clone();
    }

    public float get(int i, int j) {
        if (i < 0 || i >= 3 || j < 0 || j >= 3) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }
        return m[i * 3 + j];
    }
}