package juanmanuel.gealma.threedimensional

import juanmanuel.gealma.threedimensional.basis.*
import juanmanuel.gealma.threedimensional.objects.*

val Number.e0
    get() = E0(this.toDouble())

val Number.s
    get() = Scalar(this.e0)

val Number.e1
    get() = E1(this.toDouble())

val Number.e2
    get() = E2(this.toDouble())

val Number.e3
    get() = E3(this.toDouble())

val Number.x
    get() = Vector3(this.toDouble(), .0, .0)
val Number.y
    get() = Vector3(.0, this.toDouble(), .0)
val Number.z
    get() = Vector3(.0, .0, this.toDouble())

val Number.e1e2
    get() = E1E2(this.toDouble())

val Number.e2e3
    get() = E2E3(this.toDouble())

val Number.e3e1
    get() = E3E1(this.toDouble())

val Number.i
    get() = Bivector3(this.toDouble(), .0, .0)
val Number.j
    get() = Bivector3(.0, this.toDouble(), .0)
val Number.k
    get() = Bivector3(.0, .0, this.toDouble())

val Number.e1e2e3
    get() = E1E2E3(this.toDouble())

val Number.l
    get() = Trivector3(this.toDouble())

operator fun Number.plus(other: Geometric3): Geometric3 {
    return other + this.toDouble()
}

operator fun Number.plus(other: Scalar): Scalar {
    return other + this.toDouble()
}

operator fun Number.plus(other: Bivector3): Rotor3 {
    return other + this.toDouble()
}

operator fun Number.plus(other: Rotor3): Rotor3 {
    return other + this.toDouble()
}

operator fun Number.minus(other: Geometric3): Geometric3 {
    return -other + this.toDouble()
}

operator fun Number.minus(other: Scalar): Scalar {
    return -other + this.toDouble()
}

operator fun Number.minus(other: Bivector3): Rotor3 {
    return -other + this.toDouble()
}

operator fun Number.minus(other: Rotor3): Rotor3 {
    return -other + this.toDouble()
}

operator fun Number.times(other: Scalar): Scalar {
    return other * this.toDouble()
}

operator fun Number.times(other: Vector3): Vector3 {
    return other * this.toDouble()
}

//operator fun Number.times(other: Paravector): Paravector {
//    return other * this.toDouble()
//}

operator fun Number.times(other: Bivector3): Bivector3 {
    return other * this.toDouble()
}

operator fun Number.div(other: Geometric3): Geometric3 {
    return other.inverse() * this.toDouble()
}