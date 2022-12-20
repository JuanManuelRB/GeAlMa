package juanmanuel.gealma.threedimensional

infix fun Geometric3.inn(other: Geometric3): Geometric3 {
    return this.inner(other)
}

infix fun Geometric3.out(other: Geometric3): Geometric3 {
    return this.outer(other)
}

val Number.i
    get() = Vector3(this.toDouble(), .0, .0)
val Number.j
    get() = Vector3(.0, this.toDouble(), .0)
val Number.k
    get() = Vector3(.0, .0, this.toDouble())

val Number.ij
    get() = Bivector3(this.toDouble(), .0, .0)
val Number.jk
    get() = Bivector3(.0, this.toDouble(), .0)
val Number.ki
    get() = Bivector3(.0, .0, this.toDouble())

val Number.ijk
    get() = Trivector3(this.toDouble())

val Vector3.I
    get() = this.vectorI()

val Vector3.J
    get() = this.vectorJ()

val Vector3.K
    get() = this.vectorK()

val Bivector3.IJ
    get() = this.bivectorIJ()

val Bivector3.JK
    get() = this.bivectorJK()

val Bivector3.KI
    get() = this.bivectorKI()

val Trivector3.IJK
    get() = this.ijk()

operator fun Number.plus(other: Geometric3): Geometric3 {
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