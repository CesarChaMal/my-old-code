fun main() {
    print("Dar dos valores : ")
    val a = readln().toDouble()
    val b = readln().toDouble()

    val suma = { x: Double, y: Double -> x + y }
    val prod = { x: Double, y: Double -> x * y }
    val sumacua = { x: Double, y: Double -> x * x + y * y }

    println("La suma es : %.2f".format(suma(a, b)))
    println("El producto es : %.2f".format(prod(a, b)))
    println("La suma de los cuadrados es : %.2f".format(sumacua(a, b)))
}
