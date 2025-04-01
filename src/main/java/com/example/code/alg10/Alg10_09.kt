fun main() {
    var (m, n) = 0 to 0
    do {
        print("Filas (1-25): "); m = readln().toInt()
        print("Columnas (1-25): "); n = readln().toInt()
    } while (m !in 1..25 || n !in 1..25)

    val a = Array(m) { DoubleArray(n) }
    for (c in 0 until n)
        for (f in 0 until m) {
            print("Elemento (${f+1},${c+1}): ")
            a[f][c] = readln().toDouble()
        }

    var prodOdd = 1.0
    var hasProd = false
    for (f in 0 until m step 2)
        for (c in 0 until n)
            if (a[f][c] != 0.0) { prodOdd *= a[f][c]; hasProd = true }

    println(if(hasProd) "Producto filas impares: $prodOdd" else "No hay producto filas impares")

    if (m == n) {
        val prodDiag = (0 until m).map { a[it][it] }.filter { it != 0.0 }.fold(1.0,Double::times)
        println("Producto diagonal principal: $prodDiag")
    } else println("Suma penúltima fila: ${a[m-2].sum()}")
}
