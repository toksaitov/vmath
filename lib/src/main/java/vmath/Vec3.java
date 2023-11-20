package vmath;

/**
 * Represents a 3-dimensional vector with basic vector operations.
 * This class provides methods to perform operations such as addition,
 * subtraction, and finding the magnitude, norm, dot product, and cross
 * product of vectors.
 */
public class Vec3 {
    private final float x, y, z;

    /**
     * Constructs a zero vector (0, 0, 0).
     */
    public Vec3() {
        this(0.0f, 0.0f, 0.0f);
    }

    /**
     * Constructs a vector with the specified x, y, and z components.
     *
     * @param x The x component of the vector.
     * @param y The y component of the vector.
     * @param z The z component of the vector.
     * @throws ArithmeticException If any of the components is NaN.
     */
    public Vec3(float x, float y, float z) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z)) {
            throw new ArithmeticException();
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the x component of this vector.
     *
     * @return The x component.
     */
    public float x() {
        return x;
    }

    /**
     * Returns the y component of this vector.
     *
     * @return The y component.
     */
    public float y() {
        return y;
    }

    /**
     * Returns the z component of this vector.
     *
     * @return The z component.
     */
    public float z() {
        return z;
    }

    /**
     * Calculates and returns the magnitude of this vector.
     *
     * @return The magnitude of the vector.
     */
    public float mag() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Normalizes this vector and returns the resulting unit vector.
     *
     * @return The normalized (unit) vector.
     */
    public Vec3 norm() {
        float norm = 1.0f / (float) Math.sqrt(x * x + y * y + z * z);
        return new Vec3(x * norm, y * norm, z * norm);
    }

    /**
     * Adds the specified vector to this vector and returns the result.
     *
     * @param other The vector to be added to this one.
     * @return The resulting vector after addition.
     */
    public Vec3 add(Vec3 other) {
        return new Vec3(x + other.x, y + other.y, z + other.z);
    }

    /**
     * Subtracts the specified vector from this vector and returns the result.
     *
     * @param other The vector to be subtracted from this one.
     * @return The resulting vector after subtraction.
     */
    public Vec3 sub(Vec3 other) {
        return new Vec3(x - other.x, y - other.y, z - other.z);
    }

    /**
     * Multiplies this vector by the specified scalar and returns the result.
     *
     * @param scalar The scalar to multiply the vector by.
     * @return The resulting vector after multiplication.
     */
    public Vec3 mul(float scalar) {
        return new Vec3(x * scalar, y * scalar, z * scalar);
    }

    /**
     * Calculates and returns the dot product of this vector and the specified
     * vector.
     *
     * @param other The vector to dot with this one.
     * @return The dot product.
     */
    public float dot(Vec3 other) {
        return x * other.x + y * other.y + z * other.z;
    }

    /**
     * Calculates and returns the cross product of this vector and the specified
     * vector.
     *
     * @param other The vector to cross with this one.
     * @return The resulting vector after the cross product.
     */
    public Vec3 cross(Vec3 other) {
        return new Vec3(
                y * other.z() - z * other.y(),
                z * other.x() - x * other.z(),
                x * other.y() - y * other.x());
    }

    /**
     * Calculates and returns the scalar triple product of this vector and two
     * specified vectors.
     *
     * @param b The second vector in the triple product.
     * @param c The third vector in the triple product.
     * @return The scalar triple product.
     */
    public float triple(Vec3 b, Vec3 c) {
        Vec3 bCrossC = b.cross(c);
        return this.dot(bCrossC);
    }

    /**
     * Returns a string representation of this vector in the format (x, y, z).
     *
     * @return A string representing the vector.
     */
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
