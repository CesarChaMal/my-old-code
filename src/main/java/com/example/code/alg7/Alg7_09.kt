fun main() {
    var n: Int
    do {
        print("Dar cantidad de numeros: ")
        n = readln().toIntOrNull() ?: 0
    } while (n <= 0)

    var pp = 1
    var maxOdd: Int? = null
    var hasEven = false

    repeat(n) {
        var x: Int
        do {
            print("Dar un valor entero distinto de cero: ")
            x = readln().toIntOrNull() ?: 0
        } while (x == 0)

        if (x % 2 == 0 && (Math.abs(x % 10) !in listOf(2, 4))) {
            pp *= x
            hasEven = true
        } else if (x % 2 != 0) {
            maxOdd = maxOdd?.let { maxOf(it, x) } ?: x
        }

        if (x > 0) {
            val divisors = (2..x/2).filter { x % it == 0 }
            divisors.forEach { println("$it es divisor de $x") }
            println("$x tuvo ${divisors.size} divisores")
        }
    }

    println(if (hasEven) "El producto de pares es: $pp" else "No hubo producto de pares")
    println(maxOdd?.let { "El mayor de los impares es: $it" } ?: "No se dieron impares")
}
