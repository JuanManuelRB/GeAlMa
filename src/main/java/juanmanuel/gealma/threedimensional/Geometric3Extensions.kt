package juanmanuel.gealma.threedimensional

import juanmanuel.gealma.basis.*

infix fun Geometric3<*>.inn(other: Geometric3<*>): Geometric3<*> {
    return this.inner(other)
}

infix fun Geometric3<*>.out(other: Geometric3<*>): Geometric3<*> {
    return this.outer(other)
}

val Geometric3<*>.s
    get() = Scalar(e0())

val Geometric3<*>.x
    get() = Vector3(e1(), E2.ZERO, E3.ZERO)

val Geometric3<*>.y
    get() = Vector3(E1.ZERO, e2(), E3.ZERO)

val Geometric3<*>.z
    get() = Vector3(E1.ZERO, E2.ZERO, e3())

val Geometric3<*>.i
    get() = Bivector3(this.e1e2(), E2E3.ZERO, E3E1.ZERO)

val Geometric3<*>.j
    get() = Bivector3(E1E2.ZERO, this.e2e3(), E3E1.ZERO)

val Geometric3<*>.k
    get() = Bivector3(E1E2.ZERO, E2E3.ZERO, this.e3e1())

val Geometric3<*>.l
    get() = Trivector3(this.e1e2e3())

//operator fun Rotor3.not(): Rotor3 = this.reverseConjugation()*/
