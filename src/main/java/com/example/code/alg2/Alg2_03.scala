object Alg2_03 extends App {
  println("Dar tres valores : ")
  val a = scala.io.StdIn.readDouble()
  val b = scala.io.StdIn.readDouble()
  val c = scala.io.StdIn.readDouble()

  if (a != 0) {
    val d = b * b - 4 * a * c
    if (d > 0) {
      val x1 = (-b + math.sqrt(d)) / (2 * a)
      val x2 = (-b - math.sqrt(d)) / (2 * a)
      println(f"Las raices son $x1%.2f  $x2%.2f")
    } else if (d == 0) {
      val x = -b / (2 * a)
      println(f"Las raices son iguales a $x%.2f")
    } else {
      println("Las raices son complejas")
    }
  } else {
    val x = -c / b
    println("La ecuacion no es de 2o grado")
    println(f"La unica raiz es : $x%.2f")
  }
}
