package juanmanuel.gealma.threedimensional

import juanmanuel.gealma.threedimensional.basis.E1
import juanmanuel.gealma.threedimensional.basis.E2
import juanmanuel.gealma.threedimensional.basis.E3
import juanmanuel.gealma.threedimensional.objects.*

infix fun Geometric3.inner(other: Geometric3): Geometric3 {
    return this.inner(other)
}

infix fun Geometric3.outer(other: Geometric3): Geometric3 {
    return this.inner(other)
}

val Geometric3.s
    get() = Scalar(e0())

val Geometric3.x
    get() = Vector3(e1(), E2(.0), E3(.0))

val Geometric3.y
    get() = Vector3(E1(.0), e2(), E3(.0))

val Geometric3.z
    get() = Vector3(E1(.0), E2(.0), e3())

//val Geometric3.x_y
//    get() = Vector3(e1(), e2(), E3(.0))
//
//val Geometric3.y_z
//    get() = Vector3(E1(.0), e2(), e3())
//
//val Geometric3.x_z
//    get() = Vector3(e1(), E2(.0), e3())

val Geometric3.i
    get() = Bivector3(this.e1e2().value(), .0, .0)

val Geometric3.j
    get() = Bivector3(.0, this.e2e3().value(), .0)

val Geometric3.k
    get() = Bivector3(.0, .0, this.e3e1().value())

val Geometric3.l
    get() = Trivector3(this.e1e2e3())

//operator fun Rotor3.not(): Rotor3 = this.reverseConjugation()


//fun main() {
//    val vec = Vector3(1.0, .0, .0)
//    println(vec inner vec)
//    println(vec outer vec)
//
//}