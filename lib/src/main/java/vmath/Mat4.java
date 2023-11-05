package vmath;

public class Mat4 {
    private final float[] m;

    public Mat4() {
        m = new float[] {
            1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f
        };
    }

    public float get(int i, int j) {
        if (i < 0 || i >= 4 || j < 0 || j >= 4) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }
        return m[i * 4 + j];
    }
}
