/**
 * Geometric Algebra module.
 * Allows the manipulation of geometric objects in 2D, 3D and 4D.
 */
module gealma {
    requires jdk.incubator.vector;

    exports juanmanuel.gealma.vga.vga3;
    exports juanmanuel.gealma.vga.vga2;
    exports juanmanuel.gealma.operations;
    exports juanmanuel.gealma.vga.basis;
    exports juanmanuel.gealma;
    exports juanmanuel.gealma.vga.basis.vga;
    exports juanmanuel.gealma.vga;
}