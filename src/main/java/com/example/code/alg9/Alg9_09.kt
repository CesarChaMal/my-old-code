// Kotlin Procedural Version
fun main() {
    var l: Int
    do {
        print("Dar el orden del arreglo (max 50): ")
        l = readln().toInt()
    } while (l <= 0 || l > 50)

    val arr = DoubleArray(l) { index ->
        print("Elemento ${index + 1}: ")
        readln().toDouble()
    }

    var pm3 = 1.0
    var piep = 1.0
    var hasParImpar = false

    for (i in arr.indices) {
        if (i % 2 == 0 && arr[i] % 2 == 0.0 && arr[i] != 0.0) {
            piep *= arr[i]
            hasParImpar = true
        }
        if (arr[i] % 3 == 0.0 && arr[i] != 0.0) {
            pm3 *= arr[i]
        }
    }

    arr.sort()

    println("\n--- Procedural ---")
    println("Producto de multiplos de 3: ${if (pm3 != 1.0) "%.2f".format(pm3) else "No hubo"}")
    println("Producto de posicion impar, valor par: ${if (hasParImpar) "%.2f".format(piep) else "No hubo"}")
    println("Arreglo ordenado: ${arr.joinToString(", ") { "%.2f".format(it) }}")
}
