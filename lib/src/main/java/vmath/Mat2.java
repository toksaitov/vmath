package vmath;

public class Mat2 {
    private final float[] m;

    public Mat2() {
        m = new float[] {
            1.0f, 0.0f,
            0.0f, 1.0f
        };
    }

    public float get(int i, int j) {
        if (i < 0 || i >= 2 || j < 0 || j >= 2) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }

        int index = i * 2 + j;

        return m[index];
    }
}