package juanmanuel.gealma.threedimensional

infix fun Geometric3.inner(other: Geometric3): Geometric3 {
    return this.inner(other)
}

infix fun Geometric3.outer(other: Geometric3): Geometric3 {
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

//fun main() {
//    val v1 = 1.i + 2.j
//    println(v1)
//    val b1 = 1.ij + 2.jk
//    println(b1)
//    val t1 = 1.ijk
//    println(t1)
//}