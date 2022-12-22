package juanmanuel.gealma.threedimensional;

import static java.lang.Math.sin;

public final class MathGeometric3 {
    private MathGeometric3() {}
    public static Vector3 lerp(Vector3 first, Vector3 second, double value) {
        return first.times(1 - value).plus(second.times(value));
    }

    public static Vector3 slerp(Vector3 first, Vector3 second, double value) {
        double angle = first.times(second).angle();
        var v1 = first.times((sin((1 - value) * angle)) / sin(angle));
        var v2 = second.times((sin(value * angle) / sin(angle)));

        return v1.plus(v2);
    }

    public static Vector3 nlerp(Vector3 first, Vector3 second, double value) {
        return lerp(first, second, value).normalized();
    }

    public static double hypot(double ... numbers) {
        double result = 0;
        for (double number : numbers) {
            result += number * number;
        }

        return Math.sqrt(result);
    }

}
