object Alg2_04 extends App {
  val a = 1.0
  val b = 2.0
  val c = 1.0

  val solver = (a: Double, b: Double, c: Double) => {
    if (a != 0) {
      val d = b * b - 4 * a * c
      if (d > 0) f"Las raices son ${( -b + math.sqrt(d)) / (2 * a)}%.2f  ${( -b - math.sqrt(d)) / (2 * a)}%.2f"
      else if (d == 0) f"Las raices son iguales a ${ -b / (2 * a)}%.2f"
      else "Las raices son complejas"
    } else {
      f"La ecuacion no es de 2o grado\nLa unica raiz es : ${ -c / b}%.2f"
    }
  }

  println(solver(a, b, c))
}
