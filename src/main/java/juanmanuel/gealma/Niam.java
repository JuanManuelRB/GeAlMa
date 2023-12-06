package juanmanuel.gealma;

import juanmanuel.gealma.vga.vga3.Vector3;

public class Niam {
    public static void main(String[] args) {
        Vector3 v = new Vector3(1, 0, 0);
        Vector3 w = new Vector3(.5, .5, 0).normalized();
        var R = v.times(w).normalized();
        System.out.println(R);
        System.out.println(R.times(v.times(R.reverse())).vector());


    }
}
