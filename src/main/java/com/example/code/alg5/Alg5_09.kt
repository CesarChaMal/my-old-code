fun main() {
    val app = Alg5_09()
    app.run()
}

class Alg5_09 {

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

    fun run() {
        var n: Int
        do {
            print("Dar cantidad de numeros: ")
            n = readln().toIntOrNull() ?: -1
            if (n <= 0) println("Cantidad invalida.")
        } while (n <= 0)

        val numbers = mutableListOf<Int>()
        repeat(n) {
            var x: Int
            do {
                print("Dar un numero: ")
                x = readln().toIntOrNull() ?: 0
                if (x == 0) println("Debe ser distinto de cero.")
            } while (x == 0)
            numbers.add(x)
        }

        var product3 = 1.0
        var sumEvenPos = 0
        var lucasCount = 0
        var hasMult3 = false

        numbers.forEachIndexed { i, x ->
            if (x % 3 == 0) {
                product3 *= x
                hasMult3 = true
            }
            if (x > 0 && x % 2 == 0) sumEvenPos += x
            if (isLucas(x)) {
                lucasCount++
                println("$x es de lucas en la posición ${i + 1}")
            }
        }

        println("La suma de pares positivos: $sumEvenPos")
        println("Los numeros pares de lucas fueron: $lucasCount")
        println(if (hasMult3) "El producto de los múltiplos de 3 es: %.2f".format(product3) else "No hubo múltiplos de 3")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Alg5_09().run()
        }
    }
}
