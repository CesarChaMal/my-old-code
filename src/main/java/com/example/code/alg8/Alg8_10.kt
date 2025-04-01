fun main() {
    val n = generateSequence {
        print("Dar el orden del arreglo (max 50): ")
        readln().toIntOrNull()
    }.first { it != null && it in 1..50 }!!

    val arr = List(n) {
        print("Elemento ${it + 1}: ")
        readln().toDouble()
    }

    val (maxVal, posMax) = arr.withIndex().maxBy { it.value }.let { it.value to it.index + 1 }

    val productEvenPositions = arr.withIndex()
        .filter { (i, v) -> (i + 1) % 2 == 0 && v != 0.0 }
        .map { it.value }
        .reduceOrNull { acc, x -> acc * x }

    val productOddValues = arr.filter { it % 2 != 0.0 }
        .reduceOrNull { acc, x -> acc * x }

    println("El mayor = %.2f su posicion es %d".format(maxVal, posMax))
    println(productEvenPositions?.let { "Producto de posicion de pares %.2f".format(it) } ?: "No hubo producto positivo de pares")
    println(productOddValues?.let { "Producto de elementos impares %.2f".format(it) } ?: "No hubo producto de elementos impares")
}
