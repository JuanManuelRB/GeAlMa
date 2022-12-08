package juanmanuel.gealma.nthdimensional;

public record Vector(GeometricElement... values) {


    public record GeometricElement(Basis basis, double value) {

    }
    public record Basis(String basis) {
        public Basis[] plus(Basis other) {
            return this.basis.equals(other.basis) ? new Basis[] {this} : new Basis[] {this, other};
        }

        public Basis times(Basis other) {
            return this.basis.equals(other.basis) ? new Basis("") : new Basis(this.basis + other.basis);
        }
    }
}
