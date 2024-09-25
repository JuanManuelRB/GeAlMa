package juanmanuel.gealma.experimentalVGA3.basis;

import juanmanuel.gealma.vga.PositiveBlade;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class E1E2 extends PositiveBlade {

    public E1E2(double value) {
        super(value, (byte) 0b11);
    }

    @Override
    public E1E2 times(double scalar) {
        return new E1E2(this.value() * scalar);
    }

    @Override
    public E1E2 reverse() {
        return new E1E2(-this.value());
    }

    public E1E2 plus(E1E2 other) {
        return new E1E2(this.value() + other.value());
    }

    public double times(E1E2 other) {
        return this.value() * other.value();
    }
}
