fun main() {
    val solve = { a: Double, b: Double, c: Double ->
        if (a != 0.0) {
            val d = b * b - 4 * a * c
            when {
                d > 0 -> "Las raices son %.2f  %.2f".format(
                    (-b + Math.sqrt(d)) / (2 * a),
                    (-b - Math.sqrt(d)) / (2 * a)
                )
                d == 0.0 -> "Las raices son iguales a %.2f".format(-b / (2 * a))
                else -> "Las raices son complejas"
            }
        } else {
            "La ecuacion no es de 2o grado\nLa unica raiz es : %.2f".format(-c / b)
        }
    }

    print("Dar tres valores (separados por espacio): ")
    val (a, b, c) = readln().split(" ").map { it.toDouble() }

    println(solve(a, b, c))
}
