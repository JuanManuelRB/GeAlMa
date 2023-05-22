/**
 * Geometric Algebra module.
 * Allows the manipulation of geometric objects in 2D, 3D and 4D.
 */
module geometricalgebra {
    requires jdk.incubator.vector;

    exports juanmanuel.gealma.threedimensional;
    exports juanmanuel.gealma.twodimensional;
    exports juanmanuel.gealma.operations;
    exports juanmanuel.gealma.basis;
    exports juanmanuel.gealma;
}