package vmath;

public class Mat2 {
    private final float[] m;

    public Mat2() {
        m = new float[]{
                1.0f, 0.0f,
                0.0f, 1.0f
        };
    }

    public Mat2(float[] initialValues) {
        if (initialValues.length != 4) {
            throw new IllegalArgumentException("Array length must be 4 for a 2x2 matrix.");
        }

        for (float value : initialValues) {
            if (Float.isNaN(value)) {
                throw new IllegalArgumentException("Array contains NaN values.");
            }
        }

        m = (initialValues).clone();
    }

    public float get(int i, int j) {
        if (i < 0 || i >= 2 || j < 0 || j >= 2) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }

        return m[i * 2 + j];
    }
}