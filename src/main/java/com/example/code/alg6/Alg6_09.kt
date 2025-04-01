fun main() {
    val app = Alg6_09()
    app.run()
}

class Alg6_09 {

    fun isLucas(x: Int): Boolean {
        var a = 1
        var b = 3
        while (a < x) {
            val temp = b
            b = a + b
            a = temp
        }
        return a == x
    }

    fun run() {
        var n: Int
        do {
            print("Dar cantidad de numeros : ")
            n = readln().toInt()
        } while (n <= 0)

        var count = 0
        var supap = 0.0
        var pm3 = 1.0
        var cluc = 0
        var hasMult3 = false

        while (count < n) {
            var x: Double
            do {
                print("Dar un numero : ")
                x = readln().toDouble()
                if (x != x.toInt().toDouble()) println("error numero decimal")
            } while (x != x.toInt().toDouble())

            val xi = x.toInt()
            count++

            if (xi > 0 && xi % 2 == 0) supap += xi
            if (xi != 0 && xi % 3 == 0) {
                pm3 *= xi
                hasMult3 = true
            }
            if (xi > 0 && isLucas(xi)) {
                cluc++
                println("%.2f es de lucas".format(x))
                println("En la posicion : $count")
            }
        }

        println("La suma de pares positivos : %.2f".format(supap))
        println("Los numeros pares de lucas fueron : $cluc")
        if (hasMult3)
            println("El producto de los multiplos de 3 es : %.2f".format(pm3))
        else
            println("No hubo producto de multiplos de 3")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Alg6_09().run()
        }
    }
}
