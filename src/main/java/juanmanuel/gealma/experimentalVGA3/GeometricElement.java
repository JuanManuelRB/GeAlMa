package juanmanuel.gealma.experimentalVGA3;

public interface GeometricElement<Self extends GeometricElement<Self>> {
    Self times(double scalar);

    default Self times(Scalar scalar) {
        return this.times(scalar.value());
    }

    Self inverse();

    default Self div(double scalar) {
        return this.times(1 / scalar);
    }

    default Self div(Scalar scalar) {
        return this.times(scalar.inverse());
    }

    int grade();

    default Self reverse() {
        return this.times(Math.pow(-1, (double) (this.grade() * (this.grade() - 1)) / 2));
    }

    default Self conjugate() {
        return this.reverse().gradeInvolution();
    }

    default Self gradeInvolution() {
        return this.times(Math.pow(-1, this.grade()));
    }
}
