package juanmanuel.gealma.threedimensional;

import static java.lang.Math.sin;

public final class MathGeometric3 {
    private MathGeometric3() {}
    public Vector3 lerp(Vector3 first, Vector3 second, double value) {
        return first.times(1 - value).plus(second.times(value));
    }

    public Vector3 slerp(Vector3 first, Vector3 second, double value) {
        double angle = new Rotor3(first, second).angle();
        var v1 = first.times((sin((1 - value) * angle)) / sin(angle));
        var v2 = second.times((sin(value * angle) / sin(angle)));

        return v1.plus(v2);
    }

    public Vector3 nlerp(Vector3 first, Vector3 second, double value) {
        return lerp(first, second, value).normalized();
    }

}
