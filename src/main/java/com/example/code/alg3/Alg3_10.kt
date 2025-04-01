fun readPositiveInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val input = readlnOrNull()?.toIntOrNull()
        if (input != null && input > 0) return input
        println("El numero que diste es cero o negativo")
    }
}

fun readValidGrade(): Int {
    while (true) {
        print("Dar una calificacion: ")
        val input = readlnOrNull()?.toIntOrNull()
        if (input != null && input in 1..100) return input
        println("El numero que diste es cero, negativo o mayor que 100")
    }
}

fun main() {
    val n = readPositiveInt("Dar cantidad de calificaciones: ")
    val grades = List(n) { readValidGrade() }

    val rep = grades.count { it <= 69 }
    val cce78 = grades.count { it in 71..79 }
    val cce89 = grades.count { it in 81..89 }
    val cce910 = grades.count { it in 91..99 }
    val exacta = grades.count { it in listOf(70, 80, 90, 100) }
    val ce = grades.count { it == 100 }
    val avg = grades.average()

    println("El numero de reprobados son : $rep")
    println("El numero de calificaciones entre 70 y 80 son : $cce78")
    println("El numero de calificaciones entre 80 y 90 son : $cce89")
    println("El numero de calificaciones entre 90 y 100 son : $cce910")
    println("El numero de calificaciones excelentes son : $ce")
    println("El numero de calificaciones exactas son : $exacta")
    println("El promedio del grupo es : %.2f".format(avg))
}
