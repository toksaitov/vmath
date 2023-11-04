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

    public Mat4(float[] other) {
        if (other.length != 16) {
            throw new IllegalArgumentException("Input array must have 16 elements");
        }

        for (float value : other) {
            if (Float.isNaN(value)) {
                throw new ArithmeticException();
            }
        }

        m = other;
    }

    public float[] mat() {
        return m;
    }
}
