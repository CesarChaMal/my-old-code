fun main() {
    var n: Int
    do {
        print("Dar el orden del arreglo (max 50): ")
        n = readln().toInt()
    } while (n <= 0 || n > 50)

    val arr = DoubleArray(n)
    println("Dar los elementos uno a uno:")
    for (i in arr.indices) {
        arr[i] = readln().toDouble()
    }

    var maxVal = arr[0]
    var posMax = 1
    var productEvenPositions = 1.0
    var productOddValues = 1.0
    var hasEvenPos = false
    var hasOddVal = false

    for (i in arr.indices) {
        if (arr[i] > maxVal) {
            maxVal = arr[i]
            posMax = i + 1
        }

        if ((i + 1) % 2 == 0 && arr[i] != 0.0) {
            productEvenPositions *= arr[i]
            hasEvenPos = true
        }

        if (arr[i] % 2 != 0.0) {
            productOddValues *= arr[i]
            hasOddVal = true
        }
    }

    println("El mayor = %.2f su posicion es %d".format(maxVal, posMax))
    println(if (hasEvenPos) "Producto de posicion de pares %.2f".format(productEvenPositions) else "No hubo producto positivo de pares")
    println(if (hasOddVal) "Producto de elementos impares %.2f".format(productOddValues) else "No hubo producto de elementos impares")
}
