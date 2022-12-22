package juanmanuel.gealma.threedimensional

infix fun Geometric3.inn(other: Geometric3): Geometric3 {
    return this.inner(other)
}

infix fun Geometric3.out(other: Geometric3): Geometric3 {
    return this.outer(other)
}

val Number.e0
    get() = Scalar(this.toDouble())
val Number.e1
    get() = Vector3(this.toDouble(), .0, .0)
val Number.e2
    get() = Vector3(.0, this.toDouble(), .0)
val Number.e3
    get() = Vector3(.0, .0, this.toDouble())

val Number.e1e2
    get() = Bivector3(this.toDouble(), .0, .0)
val Number.e2e3
    get() = Bivector3(.0, this.toDouble(), .0)
val Number.e3e1
    get() = Bivector3(.0, .0, this.toDouble())

val Number.i
    get() = Bivector3(this.toDouble(), .0, .0)
val Number.j
    get() = Bivector3(.0, this.toDouble(), .0)
val Number.k
    get() = Bivector3(.0, .0, this.toDouble())

val Number.e1e2e3
    get() = Trivector3(this.toDouble())

val Vector3.x
    get() = Vector3(this.e1, .0, .0)

val Vector3.y
    get() = Vector3(.0, this.e2, .0)

val Vector3.z
    get() = Vector3(.0, .0, this.e3)

val Bivector3.i
    get() = Bivector3(this.e1e2, .0, .0)

val Bivector3.j
    get() = Bivector3(.0, this.e2e3, .0)

val Bivector3.k
    get() = Bivector3(.0, .0, this.e3e1)

operator fun Number.plus(other: Geometric3): Geometric3 {
    return other + this.toDouble()
}

operator fun Number.plus(other: Scalar): Scalar {
    return other + this.toDouble()
}

operator fun Number.plus(other: Bivector3): Rotor3 {
    return other + this.toDouble()
}

operator fun Number.minus(other: Geometric3): Geometric3 {
    return -other + this.toDouble()
}

operator fun Number.times(other: Geometric3): Geometric3 {
    return other * this.toDouble()
}

operator fun Number.div(other: Geometric3): Geometric3 {
    return other.inverse() * this.toDouble()
}

operator fun Rotor3.not() = this.reverse()