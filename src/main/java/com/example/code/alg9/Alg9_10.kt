// Kotlin Functional Version
fun main() {
    val l = generateSequence {
        print("Dar el orden del arreglo (max 50): ")
        readln().toIntOrNull()
    }.first { it != null && it in 1..50 }!!

    val arr = List(l) {
        print("Elemento ${it + 1}: ")
        readln().toDouble()
    }

    val pm3 = arr.filter { it % 3 == 0.0 && it != 0.0 }
        .reduceOrNull { acc, x -> acc * x }

    val piep = arr.withIndex()
        .filter { (i, v) -> i % 2 == 0 && v % 2 == 0.0 && v != 0.0 }
        .map { it.value }
        .reduceOrNull { acc, x -> acc * x }

    val sorted = arr.sorted()

    println("\n--- Functional ---")
    println("Producto de multiplos de 3: ${pm3?.let { "%.2f".format(it) } ?: "No hubo"}")
    println("Producto de posicion impar, valor par: ${piep?.let { "%.2f".format(it) } ?: "No hubo"}")
    println("Arreglo ordenado: ${sorted.joinToString(", ") { "%.2f".format(it) }}")
}
