fun main() {
    val dimensions = generateSequence {
        print("Ingrese filas y columnas (1-25): ")
        val input = readlnOrNull()
        val values = input?.split(" ")?.mapNotNull { it.toIntOrNull() }
        if (values == null || values.size != 2 || values.any { it !in 1..25 }) {
            println("Entrada inválida. Debe ingresar dos números entre 1 y 25 separados por espacio.")
            null
        } else {
            values
        }
    }.firstOrNull() ?: return

    if (dimensions == null) {
        println("No se ingresaron dimensiones válidas. Terminando programa.")
        return
    }

    val (m, n) = dimensions
    println("Filas: $m, Columnas: $n")

    println("Dar los elementos uno a uno por columnas:")
    val matrix = List(m) { i ->
        List(n) { j ->
            print("Elemento (${i + 1},${j + 1}): ")
            readLine()!!.toDouble()
        }
    }

    val productRowK = matrix.last().reduce { a, b -> a * b }
    val minElement = matrix.flatten().minOrNull() ?: 0.0

    println("Producto fila $m: %.2f".format(productRowK))
    println("Menor elemento: %.2f".format(minElement))
}
