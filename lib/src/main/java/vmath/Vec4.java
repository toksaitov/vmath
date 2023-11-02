package vmath;

public class Vec4 {
    private float x, y, z, w;

    public Vec4() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float z() {
        return z;
    }

    public float w() {
        return w;
    }

    public float mag() {
        return 0.0f;
    }

    public Vec4 norm() {
        return new Vec4();
    }

    public Vec4 add(Vec4 other) {
        return new Vec4();
    }

    public Vec4 sub(Vec4 other) {
        return new Vec4();
    }

    public Vec4 mul(float scalar) {
        return new Vec4();
    }

    public float dot(Vec4 other) {
        return 0.0f;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
