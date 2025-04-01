fun main() {
    print("Dar tres valores (separados por espacio): ")
    val (a, b, c) = readln().split(" ").map { it.toDouble() }

    if (a != 0.0) {
        val d = b * b - 4 * a * c
        if (d > 0) {
            val x1 = (-b + Math.sqrt(d)) / (2 * a)
            val x2 = (-b - Math.sqrt(d)) / (2 * a)
            println("Las raices son %.2f  %.2f".format(x1, x2))
        } else if (d == 0.0) {
            val x = -b / (2 * a)
            println("Las raices son iguales a %.2f".format(x))
        } else {
            println("Las raices son complejas")
        }
    } else {
        println("La ecuacion no es de 2o grado")
        val x = -c / b
        println("La unica raiz es : %.2f".format(x))
    }
}
