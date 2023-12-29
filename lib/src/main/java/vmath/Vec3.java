package vmath;

/**
 * Represents a three-dimensional vector with floating-point values.
 */

public class Vec3 {
    private final float x, y, z;

    /**
     * Constructs a zero vector (0.0f, 0.0f, 0.0f).
     */

    public Vec3() {
        this(0.0f, 0.0f, 0.0f);
    }

    /**
     * Constructs a vector with the specified x, y, and z components.
     *
     * @param x The x-component of the vector.
     * @param y The y-component of the vector.
     * @param z The z-component of the vector.
     * @throws ArithmeticException if any of the components are NaN.
     */

    public Vec3(float x, float y, float z) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z)) {
            throw new ArithmeticException("Vector components cannot be NaN.");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the x-component of the vector.
     *
     * @return The x-component.
     */

    public float x() {
        return x;
    }

    /**
     * Returns the y-component of the vector.
     *
     * @return The y-component.
     */

    public float y() {
        return y;
    }

    /**
     * Returns the z-component of the vector.
     *
     * @return The z-component.
     */

    public float z() {
        return z;
    }

    /**
     * Calculates the magnitude (length) of the vector.
     *
     * @return The magnitude of the vector.
     */

    public float mag() {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    /**
     * Calculates the square of the magnitude (length) of the vector.
     *
     * @return The square of the magnitude of the vector.
     */

    public float magSqr() {
        return x*x + y*y + z*z;
    }

    /**
     * Normalizes the vector to unit length.
     *
     * @return A new vector with the same direction but unit length.
     */

    public Vec3 norm() {
        float norm = 1.0f / (float) Math.sqrt(x*x + y*y + z*z);
        return new Vec3(x*norm, y*norm, z*norm);
    }

    /**
     * Adds the specified vector to this vector.
     *
     * @param other The vector to add.
     * @return A new vector representing the sum of this and the other vector.
     */

    public Vec3 add(Vec3 other) {
        return new Vec3(x + other.x, y + other.y, z + other.z);
    }

    /**
     * Subtracts the specified vector from this vector.
     *
     * @param other The vector to subtract.
     * @return A new vector representing the difference of this and the other vector.
     */

    public Vec3 sub(Vec3 other) {
        return new Vec3(x - other.x, y - other.y, z - other.z);
    }

    /**
     * Multiplies this vector by a scalar.
     *
     * @param scalar The scalar to multiply with.
     * @return A new vector representing the scaled vector.
     */

    public Vec3 mul(float scalar) {
        return new Vec3(x*scalar, y*scalar, z*scalar);
    }

    /**
     * Calculates the dot product of this vector with another vector.
     *
     * @param other The other vector.
     * @return The dot product of this vector and the other vector.
     */

    public float dot(Vec3 other) {
        return x*other.x + y*other.y + z*other.z;
    }

    /**
     * Calculates the cross product of this vector with another vector.
     *
     * @param other The other vector.
     * @return A new vector representing the cross product of this vector and the other vector.
     */

    public Vec3 cross(Vec3 other) {
        return new Vec3(
            y*other.z() - z*other.y(),
            z*other.x() - x*other.z(),
            x*other.y() - y*other.x()
        );
    }

    /**
     * Calculates the triple product of this vector with two other vectors.
     *
     * @param b The second vector.
     * @param c The third vector.
     * @return The triple product of the vectors.
     */

    public float triple(Vec3 b, Vec3 c) {
        Vec3 bCrossC = b.cross(c);
        return this.dot(bCrossC);
    }

    /**
     * Performs a linear interpolation between this vector and another vector.
     *
     * @param other The other vector.
     * @param t The interpolation factor.
     * @return A new vector representing the linearly interpolated vector.
     */

    public Vec3 lerp(Vec3 other, float t) {
        float newX = (1 - t)*x + t*other.x;
        float newY = (1 - t)*y + t*other.y;
        float newZ = (1 - t)*z + t*other.z;
        return new Vec3(newX, newY, newZ);
    }

    /**
     * Returns a string representation of the vector.
     *
     * @return A string in the format "(x, y, z)".
     */

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

