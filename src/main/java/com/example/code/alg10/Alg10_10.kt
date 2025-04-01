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
    }.firstOrNull()

    if (dimensions == null) {
        println("No se ingresaron dimensiones válidas. Terminando programa.")
        return
    }

    val (m, n) = dimensions
    println("Filas: $m, Columnas: $n")

    println("Dar los elementos uno a uno por columnas:")
    val matrixByColumn = List(n) { col ->
        List(m) { row ->
            print("Elemento (${row + 1},${col + 1}): ")
            readln().toDouble()
        }
    }

    val matrix = List(m) { row -> List(n) { col -> matrixByColumn[col][row] } }

    val prodOddRows = matrix.withIndex()
        .filter { it.index % 2 == 0 }
        .flatMap { it.value }
        .filter { it != 0.0 }
        .fold(1.0) { acc, v -> acc * v }

    println("\nProducto filas impares: %.2f".format(prodOddRows))

    if (m == n) {
        val prodDiagonal = (0 until m)
            .map { matrix[it][it] }
            .filter { it != 0.0 }
            .fold(1.0) { acc, v -> acc * v }

        println("Producto diagonal principal: %.2f".format(prodDiagonal))
    } else {
        val sumPenultRow = matrix[m - 2].sum()
        println("Suma penúltima fila: %.2f".format(sumPenultRow))
    }

    println("\nMatriz leída:")
    matrix.forEach { row ->
        println(row.joinToString(" ") { "%.2f".format(it) })
    }
}
