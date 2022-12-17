package juanmanuel.gealma.nthdimensional;

public record Vector(double value, GeometricObject.Basis basis) {
    public Vector {
        if (basis.basis().length() != 1)
            throw new IllegalArgumentException("Vector basis cant be more than one dimension");
    }

    public Vector(double value, String basis) {
        this(value, new GeometricObject.Basis(basis));
    }
}
