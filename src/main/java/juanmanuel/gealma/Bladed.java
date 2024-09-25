package juanmanuel.gealma;

import juanmanuel.gealma.experimentalVGA3.E0;
import juanmanuel.gealma.experimentalVGA3.basis.NegativeQuadraticForm;
import juanmanuel.gealma.experimentalVGA3.basis.PositiveBase;
import juanmanuel.gealma.experimentalVGA3.basis.ZeroQuadraticForm;

public sealed interface Bladed<Self extends Bladed<Self>> permits NegativeQuadraticForm, PositiveBase, ZeroQuadraticForm, E0 {
    double value();
    int baseCount();

    Self reverse();

    Self inc();
    Self dec();

    Self times(double scalar);

    default Self unaryMinus() {
        return times(-1);
    }

    default Self inverse() {
        return times(1 / (value() * value()));
    }

    default Self div(double scalar) {
        return this.times(1 / scalar);
    }

    <E extends Bladed<E>> E times(Self other);

    default <E extends Bladed<E>> E div(Self other) {
        return times(other.inverse());
    }


    boolean containsBase(int n);
    boolean isPositiveQuadraticFormBase(int i);

    boolean isNegativeQuadraticFormBase(int i);
    boolean isZeroQuadraticFormBase(int i);

    boolean containsBasis(int mask);

//    Self plus(Self other);

//    default Self minus(Self other) {
//        return this.plus(other.unaryMinus());
//    }

//    default Self times(Blade0<?> other) {
//        return this.times(other.value());
//    }

//    default Blade0<?> times(Self other) {
//        return new E0(this.value() * other.reverse().value());
//    }

//    default Self div(Blade0<?> other) {
//        return this.times(other.inverse());
//    }

//    default Blade0<?> div(Self other) {
//        return this.times(other.inverse());
//    }
}
