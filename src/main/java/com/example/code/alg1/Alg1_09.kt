fun main() {
    print("Dar dos valores : ")
    val a = readln().toDouble()
    val b = readln().toDouble()

    val suma = a + b
    val prod = a * b
    val sumacua = a * a + b * b

    println("La suma es : %.2f".format(suma))
    println("El producto es : %.2f".format(prod))
    println("La suma de los cuadrados es : %.2f".format(sumacua))
}
