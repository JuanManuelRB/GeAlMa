package juanmanuel.gealma.basis;

public sealed interface Blade<Self extends Blade<Self>> permits Blade0, Blade1, Blade2, Blade3, Blade4 {
    Blade<?> ZERO = new E0(0);
    Blade<?> ONE = new E0(1);

    double value();
    Self plus(Self other);
    Self times(double scalar);
    Self unaryMinus();
    Self inverse();

    default Self minus(Self other) {
        return this.plus(other.unaryMinus());
    }

    default Self times(Blade0<?> other) {
        return this.times(other.value());
    }

    default Blade0<?> times(Self other) {
        return new E0(this.value() * other.reverse().value());
    }
    default Self div(double scalar) {
        return this.times(1 / scalar);
    }

    default Self div(Blade0<?> other) {
        return this.times(other.inverse());
    }
    default Blade0<?> div(Self other) {
        return this.times(other.inverse());
    }

    Self inc();
    Self dec();
    Self reverse();
}
