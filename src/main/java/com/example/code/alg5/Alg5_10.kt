fun main() {
    val app = Alg5_10()
    app.run()
}

class Alg5_10 {

    fun isLucas(n: Int): Boolean {
        if (n < 0) return false
        var a = 2
        var b = 1
        while (a < n) {
            val temp = a + b
            a = b
            b = temp
        }
        return a == n
    }

    fun readInt(prompt: String): Int {
        while (true) {
            print(prompt)
            val input = readlnOrNull()?.toIntOrNull()
            if (input != null) return input
            println("Entrada inválida")
        }
    }

    fun run() {
        var n = readInt("Dar cantidad de numeros: ")
        while (n <= 0) n = readInt("Cantidad invalida. Intenta de nuevo: ")

        val numbers = List(n) {
            var x: Int
            do {
                x = readInt("Dar un numero (distinto de cero): ")
            } while (x == 0)
            x
        }

        val product3 = numbers.filter { it % 3 == 0 }.fold(1.0) { acc, x -> acc * x }
        val sumEven = numbers.filter { it > 0 && it % 2 == 0 }.sum()
        val lucasEven = numbers.count { it % 2 == 0 && isLucas(it) }

        println("La suma de pares positivos: $sumEven")
        println("Los numeros pares de lucas fueron: $lucasEven")
        println(if (numbers.any { it % 3 == 0 }) "El producto de los múltiplos de 3 es: %.2f".format(product3) else "No hubo múltiplos de 3")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Alg5_10().run()
        }
    }
}
