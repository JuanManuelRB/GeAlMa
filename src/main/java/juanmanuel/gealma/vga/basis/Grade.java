package juanmanuel.gealma.vga.basis;

public interface Grade<Self extends Grade<Self>> {
    int grade();

    Self plus(Self self);
    Self minus(Self self);

    Self unaryMinus();

    Grade0<?> times(Self self);
    Self times(double scalar);
    Self times(Grade0<?> scalar);

    Self inverse();

    Grade0<?> div(Self self);
    Self div(double scalar);
    Self div(Grade0<?> scalar);

    interface Grade0<Self extends Grade0<Self>> extends Grade<Self> {
        default int grade() {
            return 0;
        }
    }

    interface Grade1<Self extends Grade1<Self>> extends Grade<Self> {
        default int grade() {
            return 1;
        }
    }

    interface Grade2<Self extends Grade2<Self>> extends Grade<Self> {
        default int grade() {
            return 2;
        }
    }

    interface Grade3<Self extends Grade3<Self>> extends Grade<Self> {
        default int grade() {
            return 3;
        }
    }

    interface Grade4<Self extends Grade4<Self>> extends Grade<Self> {
        default int grade() {
            return 4;
        }
    }
}
