package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.vga.basis.vga.E0;

public sealed interface Blade0<Self extends Blade0<Self>> extends Blade<Self> permits E0 {
    Self plus(Blade0<?> other);

    default Blade<?> times(Blade1<?> other) {
        return other.times(this);
    }
    default Blade<?> times(Blade2<?> other) {
        return other.times(this);
    }
    default Blade<?> times(Blade3<?> other) {
        return other.times(this);
    }
    default Blade<?> times(Blade4<?> other) {
        return other.times(this);
    }
    default Blade<?> div(Blade1<?> other) {
        return other.times(this.inverse());
    }
    default Blade<?> div(Blade2<?> other) {
        return other.times(this.inverse());
    }
    default Blade<?> div(Blade3<?> other) {
        return other.times(this.inverse());
    }
    default Blade<?> div(Blade4<?> other) {
        return other.times(this.inverse());
    }
}
