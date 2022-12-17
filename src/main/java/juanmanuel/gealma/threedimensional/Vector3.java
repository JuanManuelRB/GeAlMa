package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Vector3(double i, double j, double k) implements Geometric3 {
    public static final Vector3 ZERO = new Vector3(0, 0, 0);
    public static final Vector3 I = new Vector3(1, 0, 0);
    public static final Vector3 J = new Vector3(0, 1, 0);
    public static final Vector3 K = new Vector3(0, 0, 1);
    public static final Vector3 ONE = new Vector3(1, 1, 1);

    public double length() {
        return magnitude();
    }

    @Override
    public double magnitude() {
        return Math.sqrt(inner(this).scalar());
    }

    public static Vector3 sum(Vector3... vectors) {
        var vec = Vector3.ZERO;
        for (var vecs : vectors) {
            vec = vec.plus(vecs).vector();
        }
        return vec.vector();
    }

    public static Geometric3 product(Vector3... vectors) {
        Geometric3 vec = Vector3.ONE;
        for (var vecs : vectors) {
            vec = vec.times(vecs);
        }
        return vec;
    }

    @NotNull @Override
    public Vector3 normalized() {
        return this.div(this.magnitude());
    }

    // Geometric Primitives

    @Override
    public double scalar() {
        return 0;
    }

    @NotNull @Override
    public Vector3 unaryMinus() {
        return new Vector3(-i, -j, -k);
    }

    @NotNull @Override
    public Vector3 unaryPlus() {
        return new Vector3(Math.abs(i), Math.abs(j), Math.abs(k));
    }

    @NotNull @Override
    public Vector3 vector() {
        return this;
    }

    // Addition

    @NotNull @Override
    public Bivector3 bivector() {
        return Bivector3.ZERO;
    }

    @NotNull @Override
    public Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @NotNull @Override
    public Geometric3 plus(double other) {
        return new Geometric3Object(other, this, Bivector3.ZERO, Trivector3.ZERO);
    }

    @NotNull @Override
    public Vector3 plus(@NotNull Vector3 other) {
        return new Vector3(this.i + other.i, this.j + other.j, this.k + other.k);
    }

    // Subtraction

    @NotNull @Override
    public Geometric3 plus(@NotNull Bivector3 other) {
        return new Geometric3Object(0, this, other, Trivector3.ZERO);
    }

    @NotNull @Override
    public Geometric3 plus(@NotNull Trivector3 other) {
        return new Geometric3Object(0, this, Bivector3.ZERO, other);
    }

    @NotNull
    @Override
    public Geometric3 minus(@NotNull Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull @Override
    public Geometric3 minus(double other) {
        return this.plus(-other);
    }

    @NotNull @Override
    public Vector3 minus(@NotNull Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull @Override
    public Geometric3 minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull @Override
    public Vector3 times(double other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Trivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @NotNull @Override
    public Geometric3 times(@NotNull Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @NotNull @Override
    public Geometric3 times(@NotNull Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @NotNull @Override
    public Vector3 inner(double other) {
        return new Vector3(i * other, j * other, k * other);
    }

    @NotNull @Override
    public Geometric3 inner(@NotNull Vector3 other) {
        return new Geometric3Object(
                this.i * other.i + this.j * other.j + this.k * other.k,
                Vector3.ZERO,
                Bivector3.ZERO,
                Trivector3.ZERO
        );
    }

    @NotNull @Override
    public Vector3 inner(@NotNull Bivector3 other) {
        //TODO: Vector computation?
        return new Vector3(
                this.k * other.ki() - this.j * other.ij(),
                this.i * other.ij() - this.k * other.jk(),
                this.j * other.jk() - this.i * other.ki()
        );
    }

    @NotNull @Override
    public Bivector3 inner(@NotNull Trivector3 other) {
        //TODO: Vector computation?
        return new Bivector3(
                this.i * other.ijk(),
                this.j * other.ijk(),
                this.k * other.ijk()
        );
    }

    @NotNull @Override
    public Geometric3 outer(double other) {
        return Geometric3Object.ZERO;
    }

    @NotNull @Override
    public Bivector3 outer(@NotNull Vector3 other) {
        return new Bivector3(
                this.i * other.j - other.i * this.j,
                this.j * other.k - other.j * this.k,
                this.k * other.i - other.k * this.i
        );
    }

    @Override
    public @NotNull Vector3 div(double other) {
        return new Vector3(i / other, j / other, k / other);
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Vector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Bivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Trivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Vector3 inverse() {
        return this.div(this.magnitude() * this.magnitude());
    }

    @NotNull @Override
    public Trivector3 outer(@NotNull Bivector3 other) {
        return new Trivector3(this.i * other.jk() + this.j * other.ki() + this.k * other.ij());
    }

    @NotNull @Override
    public Geometric3 outer(@NotNull Trivector3 other) {
        return Geometric3Object.ZERO;
    }

    @Override
    public String toString() {
        var str = "";
        if (i != 0)
            str += i + "(i)";

        if (j != 0){
            if (i != 0)
                str += " + ";
            str += j + "(j)";
        }

        if (k != 0) {
            if (j != 0)
                str += " + ";
            str += k + "(k)";
        }
        return str;

        //return "" + i + "i + " + j + "j + " + k + "k";
    }
}
