fun main() {
    print("Dar cantidad de calificaciones: ")
    var n = readln().toInt()
    while (n <= 0) {
        println("El numero que diste es cero o negativo")
        print("Da otro valor: ")
        n = readln().toInt()
    }

    var rep = 0
    var cce78 = 0
    var cce89 = 0
    var cce910 = 0
    var exacta = 0
    var ce = 0
    var sum = 0

    repeat(n) {
        var c: Int
        do {
            print("Dar una calificacion: ")
            c = readln().toInt()
            if (c <= 0 || c > 100)
                println("El numero que diste es cero, negativo o mayor que 100")
        } while (c <= 0 || c > 100)

        when {
            c <= 69 -> rep++
            c in 71..79 -> cce78++
            c in 81..89 -> cce89++
            c in 91..99 -> cce910++
            c in listOf(70, 80, 90) -> exacta++
            c == 100 -> { exacta++; ce++ }
        }
        sum += c
    }

    val avg = sum.toDouble() / n
    println("El numero de reprobados son : $rep")
    println("El numero de calificaciones entre 70 y 80 son : $cce78")
    println("El numero de calificaciones entre 80 y 90 son : $cce89")
    println("El numero de calificaciones entre 90 y 100 son : $cce910")
    println("El numero de calificaciones excelentes son : $ce")
    println("El numero de calificaciones exactas son : $exacta")
    println("El promedio del grupo es : %.2f".format(avg))
}
