fun main() {
    var n: Int
    do {
        print("Dar cantidad de numeros: ")
        n = readln().toIntOrNull() ?: -1
        if (n <= 0) println("Cantidad invalida. Da otro valor.")
    } while (n <= 0)

    val numbers = buildList {
        repeat(n) {
            var x: Int
            do {
                print("Dar un valor entero (distinto de cero): ")
                x = readln().toIntOrNull() ?: 0
                if (x == 0) println("Valor invalido. Debe ser distinto de cero.")
            } while (x == 0)
            add(x)
        }
    }

    val productEven = numbers.filter { it % 2 == 0 }.fold(1.0) { acc, x -> acc * x }
    val validOdds = numbers.filter { it % 2 != 0 && Math.abs(it) % 10 != 3 }
    val productOdd = validOdds.takeIf { it.isNotEmpty() }?.fold(1.0) { acc, x -> acc * x }

    val min = numbers.minOrNull()
    val max = numbers.maxOrNull()
    val posMax = numbers.indexOf(max) + 1

    println("El producto de pares es : %.2f".format(productEven))
    println("El producto de impares es (menos los terminados en 3) : ${productOdd?.let { "%.2f".format(it) } ?: "No hay impares válidos"}")
    println("El menor : $min         El mayor es : $max")
    println("La posicion del mayor es : $posMax")
}
