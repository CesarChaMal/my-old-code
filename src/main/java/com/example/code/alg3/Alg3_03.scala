object Alg3_03 extends App {
  println("Dar cantidad de calificaciones : ")
  var n = scala.io.StdIn.readInt()
  while (n <= 0) {
    println("El numero que diste es cero o negativo")
    print("Da otro valor : ")
    n = scala.io.StdIn.readInt()
  }

  var rep, cce78, cce89, cce910, exacta, ce, sumc = 0

  for (_ <- 1 to n) {
    var c = 0
    do {
      print("Dar una calificacion : ")
      c = scala.io.StdIn.readInt()
      if (c <= 0 || c > 100)
        println("El numero que diste es cero, negativo o mayor que 100")
    } while (c <= 0 || c > 100)

    c match {
      case x if x <= 69      => rep += 1
      case x if x >= 71 && x <= 79 => cce78 += 1
      case x if x >= 81 && x <= 89 => cce89 += 1
      case x if x >= 91 && x <= 99 => cce910 += 1
      case 70 | 80 | 90      => exacta += 1
      case 100               => exacta += 1; ce += 1
    }

    sumc += c
  }

  val avg = sumc.toDouble / n
  println(s"\nEl numero de reprobados son : $rep")
  println(s"El numero de calificaciones entre 70 y 80 son : $cce78")
  println(s"El numero de calificaciones entre 80 y 90 son : $cce89")
  println(s"El numero de calificaciones entre 90 y 100 son : $cce910")
  println(s"El numero de calificaciones excelentes son : $ce")
  println(s"El numero de calificaciones exactas son : $exacta")
  println(f"El promedio del grupo es : $avg%.2f")
}
