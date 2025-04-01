fun main() {
    print("Dar cantidad de numeros: ")
    var n = readln().toInt()
    while (n <= 0) {
        print("Cantidad invalida. Da otro valor: ")
        n = readln().toInt()
    }

    var pp = 1.0
    var pim = 1.0
    var hasOdd = false
    var min: Int? = null
    var max: Int? = null
    var posMax = 0

    repeat(n) { index ->
        var x: Int
        do {
            print("Dar un valor entero: ")
            x = readln().toInt()
        } while (x == 0)

        if (index == 0) {
            min = x
            max = x
            posMax = 1
        }

        if (x % 2 == 0) {
            pp *= x
        } else if (Math.abs(x) % 10 != 3) {
            pim *= x
            hasOdd = true
        }

        if (x < min!!) min = x
        if (x > max!!) {
            max = x
            posMax = index + 1
        }
    }

    println("El producto de pares es : %.2f".format(pp))
    println("El producto de impares es (menos los terminados en 3) : ${"%.2f".format(pim)}".takeIf { hasOdd } ?: "No hay impares válidos")
    println("El menor : $min         El mayor es : $max")
    println("La posicion del mayor es : $posMax")
}
