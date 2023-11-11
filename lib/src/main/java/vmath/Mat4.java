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

    public Mat4 mul(Mat4 other) {
        Mat4 result = new Mat4();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float value = 0;
                for (int k = 0; k < 4; k++) {
                    value += this.get(i, k) * other.get(k, j);
                }
                result.m[i * 4 + j] = value;
            }
        }
        return result;
    }
}

    public float get(int i, int j) {
        if (i < 0 || i >= 4 || j < 0 || j >= 4) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }
        return m[i * 4 + j];
    }
}
