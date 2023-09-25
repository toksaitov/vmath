package vmath;

public class Vec2 {
    private float x;
    private float y;

    public Vec2() {
        this(0.0f, 0.0f);
    }

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float mag() {
        return 0.0f;
    }

    public Vec2 norm() {
        return null;
    }

    public Vec2 add(Vec2 other) {
        return null;
    }

    public Vec2 sub(Vec2 other) {
        return null;
    }

    public Vec2 mul(float other) {
        return null;
    }

    public float dot(Vec2 other) {
        return 0.0f;
    }
}
