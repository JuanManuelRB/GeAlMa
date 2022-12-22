package juanmanuel.gealma.threedimensional;

import juanmanuel.gealma.nthdimensional.Geometric;
import org.jetbrains.annotations.NotNull;

public interface Geometric3 extends Geometric {
    @NotNull Scalar scalar();
    @NotNull Vector3 vector();
    @NotNull Bivector3 bivector();
    @NotNull Trivector3 trivector();

    default double e0() {
        return scalar().e0();
    }

    default double e1() {
        return vector().e1();
    }

    default double e2() {
        return vector().e2();
    }

    default double e3() {
        return vector().e3();
    }

    default double e1e2() {
        return bivector().e1e2();
    }

    default double e2e3() {
        return bivector().e2e3();
    }

    default double e3e1() {
        return bivector().e3e1();
    }

    default double e1e2e3() {
        return trivector().e1e2e3();
    }


    // Addition
    @NotNull Geometric3 plus(double other);

    @NotNull default Geometric3 plus(@NotNull Scalar other) {
        return plus(other.e0());
    }
    @NotNull Geometric3 plus(@NotNull Vector3 other);
    @NotNull Geometric3 plus(@NotNull Bivector3 other);
    @NotNull Geometric3 plus(@NotNull Trivector3 other);
    @NotNull
    default Geometric3 plus(@NotNull Geometric3 other) {
        return new Geometric3Object(
                this.e0() + other.e0(),
                this.e1() + other.e0(),
                this.e2() + other.e0(),
                this.e3() + other.e0(),
                this.e1e2() + other.e0(),
                this.e2e3() + other.e0(),
                this.e3e1() + other.e0(),
                this.e1e2e3() + other.e0()
        );
    }

    // Subtraction
    @NotNull Geometric3 minus(double other);
    @NotNull default Geometric3 minus(Scalar other) {
        return minus(other.e0());
    }
    @NotNull Geometric3 minus(@NotNull Vector3 other);
    @NotNull Geometric3 minus(@NotNull Bivector3 other);
    @NotNull Geometric3 minus(@NotNull Trivector3 other);
    @NotNull
    default Geometric3 minus(@NotNull Geometric3 other) {
        return new Geometric3Object(
                this.e0() - other.e0(),
                this.e1() - other.e0(),
                this.e2() - other.e0(),
                this.e3() - other.e0(),
                this.e1e2() - other.e0(),
                this.e2e3() - other.e0(),
                this.e3e1() - other.e0(),
                this.e1e2e3() - other.e0()
        );
    }

    // Inner Product
    @NotNull Geometric3 inner(double other);
    @NotNull default Geometric3 inner(Scalar other) {
        return inner(other.e0());
    }
    @NotNull Geometric3 inner(@NotNull Vector3 other);
    @NotNull Geometric3 inner(@NotNull Bivector3 other);
    @NotNull Geometric3 inner(@NotNull Trivector3 other);
    @NotNull
    default Geometric3 inner(Geometric3 geometric3) {
        return this.inner(geometric3.scalar()).plus(this.inner(geometric3.vector())).plus(this.inner(geometric3.bivector())).plus(this.inner(geometric3.trivector()));
    }

    // Outer Product
    @NotNull Geometric3 outer(double other);
    @NotNull default Geometric3 outer(Scalar other) {
        return outer(other.e0());
    }
    @NotNull Geometric3 outer(@NotNull Vector3 other);
    @NotNull Geometric3 outer(@NotNull Bivector3 other);
    @NotNull Geometric3 outer(@NotNull Trivector3 other);
    @NotNull
    default Geometric3 outer(Geometric3 geometric3) {
        return this.outer(geometric3.scalar())
                .plus(this.outer(geometric3.vector()))
                .plus(this.outer(geometric3.bivector()))
                .plus(this.outer(geometric3.trivector()));
    }

    // Product
    @NotNull Geometric3 times(double other);
    @NotNull
    default Geometric3 times(Scalar other) {
        //return new Geometric3Object(scalar().times(other), vector().times(other), bivector().times(other), trivector().times(other));
        return new Geometric3Object(
                this.e0() * other.e0(),
                this.e1() * other.e0(),
                this.e2() * other.e0(),
                this.e3() * other.e0(),
                this.e1e2() * other.e0(),
                this.e2e3() * other.e0(),
                this.e3e1() * other.e0(),
                this.e1e2e3() * other.e0()
        );
    }
    @NotNull Geometric3 times(@NotNull Vector3 other);
    @NotNull Geometric3 times(@NotNull Bivector3 other);
    @NotNull Geometric3 times(@NotNull Trivector3 other);
    @NotNull
    default Geometric3 times(Geometric3 other) {
        return this.times(other.scalar())
                .plus(this.times(other.vector()))
                .plus(this.times(other.bivector()))
                .plus(this.times(other.trivector()));
    }

    @NotNull Geometric3 inverse();

    @NotNull Geometric3 div(double other);
    @NotNull
    default Geometric3 div(Scalar other) {
        return new Geometric3Object(
                this.e0() / other.e0(),
                this.e1() / other.e0(),
                this.e2() / other.e0(),
                this.e3() / other.e0(),
                this.e1e2() / other.e0(),
                this.e2e3() / other.e0(),
                this.e3e1() / other.e0(),
                this.e1e2e3() / other.e0()
        );
    }
    @NotNull Geometric3 div(@NotNull Vector3 other);
    @NotNull Geometric3 div(@NotNull Bivector3 other);
    @NotNull Geometric3 div(@NotNull Trivector3 other);


    @NotNull Geometric3 unaryMinus();
    @NotNull Geometric3 unaryPlus();
}
