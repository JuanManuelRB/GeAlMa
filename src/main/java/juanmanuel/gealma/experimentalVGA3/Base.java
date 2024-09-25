package juanmanuel.gealma.experimentalVGA3;

public interface Base<Self extends Base<Self>> extends GeometricElement<Self> {
    byte basis();

    double value();
    Self plus(Self other);

    Self unaryMinus();
    default Self minus(Self other) {
        return this.plus(other.unaryMinus());
    }

    Scalar times(Self other);
    default Scalar div(Self other) {
        return this.times(other.inverse());
    }
}
