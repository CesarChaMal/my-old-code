fun divisors(x: Int) = (2..x / 2).filter { x % it == 0 }

fun main() {
    val n = generateSequence {
        print("Dar cantidad de numeros: ")
        readln().toIntOrNull()
    }.first { it != null && it > 0 }

    val numbers = generateSequence {
        print("Dar un valor entero distinto de cero: ")
        readln().toIntOrNull()?.takeIf { it != 0 }
    }.take(n).toList()

    val productEven = numbers.filter { it % 2 == 0 && it % 10 !in listOf(2,4) }.fold(1) { acc, x -> acc * x }
    val maxOdd = numbers.filter { it % 2 != 0 }.maxOrNull()

    numbers.filter { it > 0 }.forEach { x ->
        val divs = divisors(x)
        divs.forEach { println("$it es divisor de $x") }
        println("$x tuvo ${divs.size} divisores")
    }

    println(if (productEven != 1) "El producto de pares es: $productEven" else "No hubo producto de pares")
    println(maxOdd?.let { "El mayor de los impares es: $it" } ?: "No se dieron impares")
}
