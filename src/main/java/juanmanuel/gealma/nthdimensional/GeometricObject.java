package juanmanuel.gealma.nthdimensional;

public record GeometricObject(GeometricElement... values) {

    public record GeometricElement(Basis basis, double value) {
        public GeometricElement[] plus(GeometricElement other) {
            return this == other ? new GeometricElement[] {this} : new GeometricElement[] {this, other};
        }
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
