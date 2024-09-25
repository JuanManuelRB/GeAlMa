package juanmanuel.gealma.experimentalVGA3.basis;

import juanmanuel.gealma.vga.PositiveBlade;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class E3 extends PositiveBlade {

    public E3(double value) {
        super(value, (byte) 0b100);
    }

    @Override
    public E3 times(double scalar) {
        return new E3(this.value() * scalar);
    }

    @Override
    public E3 reverse() {
        return new E3(this.value());
    }

    @Override
    public E3 inverse() {
        return new E3(1 / this.value());
    }

    public E3 plus(E3 other) {
        return new E3(this.value() + other.value());
    }

    public double times(E3 other) {
        return this.value() * other.value();
    }
}
