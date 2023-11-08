package vmath;

public class Mat2 {
    private final float[] m;

    public Mat2() {
        m = new float[] {
            1.0f, 0.0f,
            0.0f, 1.0f
        };
    }

    public Mat2(float[] initialValues) {
        if (initialValues.length != 4) {
            throw new IllegalArgumentException("Initial values array must have exactly 4 elements.");
        }

        for(int i = 0; i < 4; ++i)
        {
            if(Float.isNaN(initialValues[i]))
            {
                throw new ArithmeticException();
            }
        }

        m = new float[4];

        for (int i = 0; i < 4; ++i) 
        {
            m[i] = initialValues[i];
        }
    }
    
    public float get(int i, int j) {
        if (i < 0 || i >= 2 || j < 0 || j >= 2) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }

        return m[i * 2 + j];
    }
}