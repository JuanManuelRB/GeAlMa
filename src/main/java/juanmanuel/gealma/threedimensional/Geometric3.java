package juanmanuel.gealma.threedimensional;

import juanmanuel.gealma.nthdimensional.Geometric;
import org.jetbrains.annotations.NotNull;

public interface Geometric3 extends Geometric {
    double scalar();
    @NotNull Vector3 vector();
    @NotNull Bivector3 bivector();
    @NotNull Trivector3 trivector();

    // Addition
    @NotNull Geometric3 plus(double other);
    @NotNull Geometric3 plus(@NotNull Vector3 other);
    @NotNull Geometric3 plus(@NotNull Bivector3 other);
    @NotNull Geometric3 plus(@NotNull Trivector3 other);

    // Subtraction
    @NotNull Geometric3 minus(double other);
    @NotNull Geometric3 minus(@NotNull Vector3 other);
    @NotNull Geometric3 minus(@NotNull Bivector3 other);
    @NotNull Geometric3 minus(@NotNull Trivector3 other);

    // Product
    // @NotNull Geometric3 times(double other);
    @NotNull Geometric3 times(@NotNull Vector3 other);
    @NotNull Geometric3 times(@NotNull Bivector3 other);
    @NotNull Geometric3 times(@NotNull Trivector3 other);

    // Inner Product
    @NotNull Geometric3 inner(double other);
    @NotNull Geometric3 inner(@NotNull Vector3 other);
    @NotNull Geometric3 inner(@NotNull Bivector3 other);
    @NotNull Geometric3 inner(@NotNull Trivector3 other);

    // Outer Product
    @NotNull Geometric3 outer(double other);
    @NotNull Geometric3 outer(@NotNull Vector3 other);
    @NotNull Geometric3 outer(@NotNull Bivector3 other);
    @NotNull Geometric3 outer(@NotNull Trivector3 other);

    @NotNull Geometric3 unaryMinus();
    @NotNull Geometric3 unaryPlus();
    double magnitude();
//    Geometric inner(Geometric other);
//    Geometric outher(Geometric other);
//    Geometric times(Geometric other);

    @NotNull
    default Geometric3 plus(@NotNull Geometric3 other) {
        return new Geometric3Object(this.scalar() + other.scalar(),
                this.vector().plus(other.vector()),
                this.bivector().plus(other.bivector()),
                this.trivector().plus(other.trivector()));
    }

    @NotNull
    default Geometric3 minus(@NotNull Geometric3 other) {
        return new Geometric3Object(this.scalar() - other.scalar(),
                this.vector().minus(other.vector()),
                this.bivector().minus(other.bivector()),
                this.trivector().minus(other.trivector()));
    }

    @NotNull
    default Geometric3 times(double other) {
        return new Geometric3Object(other * scalar(), vector().times(other), bivector().times(other), trivector().times(other));
    }

}
