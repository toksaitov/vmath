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

    public Mat4(float[] m) {
        if (m == null || m.length != 16) {
            throw new IllegalArgumentException();
        }
        for (float value : m) {
            if (Float.isNaN(value)) {
                throw new ArithmeticException();
            }
        }
        this.m = m.clone();
    }

    public float get(int i, int j) {
        if (i < 0 || i >= 4 || j < 0 || j >= 4) {
            throw new IndexOutOfBoundsException();
        }
        return m[i * 4 + j];
    }
}
