import scala.io.StdIn._

object Alg7_03 extends App {
  var n = 0
  while (n <= 0) {
    print("Dar cantidad de numeros: ")
    n = readInt()
  }

  var pp = 1.0
  var maxOdd = Int.MinValue
  var hasEven, hasOdd = false

  for (_ <- 1 to n) {
    var x = 0
    do {
      print("Dar un valor entero: ")
      x = readInt()
    } while (x == 0)

    if (x % 2 == 0 && math.abs(x % 10) != 2 && math.abs(x % 10) != 4) {
      pp *= x
      hasEven = true
    } else if (x % 2 != 0) {
      if (!hasOdd || x > maxOdd) {
        maxOdd = x
        hasOdd = true
      }
    }

    if (x > 0) {
      val divisors = (2 to x/2).filter(x % _ == 0)
      divisors.foreach(d => println(s"$d es divisor de $x"))
      println(s"$x tuvo ${divisors.size} divisores")
    }
  }

  println(if (hasEven) s"El producto de pares es: $pp" else "No hubo producto de pares")
  println(if (hasOdd) s"El mayor de los impares es: $maxOdd" else "No se dieron impares")
}
