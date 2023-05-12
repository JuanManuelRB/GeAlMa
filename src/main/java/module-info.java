/**
 * Geometric Algebra module.
 * Allows the manipulation of Vectors, Bivectors, Trivectors, Rotors, and other Geometric elements in a 3-dimensional
 * space.
 */
module geometricalgebra {
    requires kotlin.stdlib;
    requires jdk.incubator.vector;

    exports juanmanuel.gealma.threedimensional;
    exports juanmanuel.gealma.operations;
    exports juanmanuel.gealma.basis;
}