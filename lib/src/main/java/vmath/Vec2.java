package vmath;

/**
 * Represents a 2-dimensional vector with float components.
 * Provides basic vector operations such as addition, subtraction,
 * multiplication, and dot product calculation.
 */
public class Vec2 {
    private final float x;
    private final float y;
    
    /**
     * Constructs a new vector with both x and y components set to zero.
     */
    public Vec2() {
        this(0.0f, 0.0f);
    }

    /**
     * Constructs a new vector with specified x and y components.
     * 
     * @param x The x component of the vector.
     * @param y The y component of the vector.
     * @throws ArithmeticException If either x or y is NaN.
     */
    public Vec2(float x, float y) {
        if (Float.isNaN(x) || Float.isNaN(y)) {
            throw new ArithmeticException();
        }
        this.x = x;
        this.y = y;
    }
    /**
     * Gets the x component of the vector.
     * 
     * @return The x component.
     */
    public float x() {
        return x;
    }
    /**
     * Gets the y component of the vector.
     * 
     * @return The y component.
     */
    public float y() {
        return y;
    }
    /**
     * Calculates the magnitude of the vector.
     * 
     * @return The magnitude of the vector.
     */
    public float mag() {
        return (float) Math.sqrt(x*x + y*y);
    }

    public Vec2 norm() {
        float norm = 1.0f / (float) Math.sqrt(x*x + y*y);
        return new Vec2(x*norm, y*norm);
    }

    public Vec2 add(Vec2 other) {
        return new Vec2(x + other.x, y + other.y);
    }

    public Vec2 sub(Vec2 other) {
        return new Vec2(x - other.x, y - other.y);
    }

    public Vec2 mul(float other) {
        return new Vec2(x*other, y*other);
    }

    public float dot(Vec2 other) {
        return x*other.x + y*other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
