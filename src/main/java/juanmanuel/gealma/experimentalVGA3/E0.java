//package juanmanuel.gealma.experimentalVGA3;
//
//public final class E0 extends Scalar implements PositiveBase<E0> {
//
//    public E0(double value) {
//        super(value);
//    }
//
//    @Override
//    public byte positiveMask() {
//        return 0;
//    }
//
//    @Override
//    public boolean isPositiveQuadraticFormBase(int base) {
//        return base == 0;
//    }
//
//    public int grade() {
//        return 0;
//    }
//
//    @Override
//    public E0 times(double scalar) {
//        return new E0(value() * scalar);
//    }
//
//    @Override
//    public E0 div(double other) {
//        return times(1 / other);
//    }
//
//    @Override
//    public E0 times(Scalar other) {
//        return new E0(value() * other.value());
//    }
//
//    @Override
//    public E0 div(Scalar scalar) {
//        return times(scalar.inverse());
//    }
//
//    @Override
//    public E0 plus(E0 other) {
//        return new E0(value() + other.value());
//    }
//
//    @Override
//    public E0 unaryMinus() {
//        return new E0(-value());
//    }
//
//    @Override
//    public Scalar times(E0 other) {
//        return new E0(value() * other.value());
//    }
//
//    @Override
//    public E0 minus(E0 other) {
//        return plus(other.unaryMinus());
//    }
//
//    @Override
//    public E0 inverse() {
//        return new E0(1 / value());
//    }
//
//    @Override
//    public Scalar div(E0 other) {
//        return times(other.inverse());
//    }
//}
