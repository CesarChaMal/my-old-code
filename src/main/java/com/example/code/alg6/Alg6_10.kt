fun main() {
    val app = Alg6_10()
    app.run()
}

class Alg6_10 {

    fun isLucas(x: Int): Boolean {
        return generateSequence(Pair(1, 3)) { Pair(it.second, it.first + it.second) }
            .map { it.first }
            .takeWhile { it <= x }
            .contains(x)
    }

    fun run() {
        var n: Int
        do {
            print("Dar cantidad de numeros : ")
            n = readln().toInt()
        } while (n <= 0)

        val nums = generateSequence {
            print("Dar un numero : ")
            val input = readln().toDouble()
            if (input != input.toInt().toDouble()) {
                println("error numero decimal")
                null
            } else input.toInt()
        }.take(n).toList()

        val sumEvenPos = nums.filter { it > 0 && it % 2 == 0 }.sumOf { it.toDouble() }

        val mult3s = nums.filter { it != 0 && it % 3 == 0 }
        val prodMult3 = mult3s.fold(1.0) { acc, x -> acc * x }

        val evenLucas = nums.mapIndexedNotNull { i, x ->
            if (x > 0 && isLucas(x)) {
                println("%.2f es de lucas".format(x.toDouble()))
                println("En la posicion : ${i + 1}")
                if (x % 2 == 0) x else null
            } else null
        }

        println("La suma de pares positivos : %.2f".format(sumEvenPos))
        println("Los numeros pares de lucas fueron : ${evenLucas.size}")
        if (mult3s.isNotEmpty())
            println("El producto de los multiplos de 3 es : %.2f".format(prodMult3))
        else
            println("No hubo producto de multiplos de 3")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Alg6_10().run()
        }
    }
}
