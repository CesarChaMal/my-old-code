object Alg3_04 extends App {
  def readGrade(): Int = {
    Iterator
      .continually({
        print("Dar una calificacion: ")
        scala.io.StdIn.readInt()
      })
      .dropWhile(c => {
        val invalid = c <= 0 || c > 100
        if (invalid) println("El numero que diste es cero, negativo o mayor que 100")
        invalid
      })
      .next()
  }

  print("Dar cantidad de calificaciones: ")
  val n = Iterator
    .continually(scala.io.StdIn.readInt())
    .dropWhile { x =>
      if (x <= 0) println("El numero que diste es cero o negativo\nDa otro valor: ")
      x <= 0
    }.next()

  val grades: List[Int] = List.fill(n)(readGrade())

  val rep = grades.count(_ <= 69)
  val cce78 = grades.count(g => g >= 71 && g <= 79)
  val cce89 = grades.count(g => g >= 81 && g <= 89)
  val cce910 = grades.count(g => g >= 91 && g <= 99)
  val exacta = grades.count(Set(70, 80, 90, 100))
  val ce = grades.count(_ == 100)
  val avg = grades.sum.toDouble / n

  println(s"\nEl numero de reprobados son : $rep")
  println(s"El numero de calificaciones entre 70 y 80 son : $cce78")
  println(s"El numero de calificaciones entre 80 y 90 son : $cce89")
  println(s"El numero de calificaciones entre 90 y 100 son : $cce910")
  println(s"El numero de calificaciones excelentes son : $ce")
  println(s"El numero de calificaciones exactas son : $exacta")
  println(f"El promedio del grupo es : $avg%.2f")
}
