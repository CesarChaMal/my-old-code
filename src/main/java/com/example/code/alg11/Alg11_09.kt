import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    var m: Int
    var n: Int

    do {
        print("Filas (max 25): ")
        m = sc.nextInt()
        print("Columnas (max 25): ")
        n = sc.nextInt()
    } while (m !in 1..25 || n !in 1..25)

    val matrix = Array(m) { DoubleArray(n) }

    for (i in 0 until m) {
        for (j in 0 until n) {
            print("Elemento (${i+1},${j+1}): ")
            matrix[i][j] = sc.nextDouble()
        }
    }

    var pkfila = 1.0
    var menor = matrix[0][0]

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i == m - 1) pkfila *= matrix[i][j]
            if (matrix[i][j] < menor) menor = matrix[i][j]
        }
    }

    println("Producto fila $m: %.2f".format(pkfila))
    println("Menor elemento: %.2f".format(menor))
}
