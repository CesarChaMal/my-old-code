import scala.io.StdIn._

object Alg5_03 {
  def main(args: Array[String]): Unit = {
    var n = 0
    do {
      print("Dar cantidad de numeros: ")
      n = readInt()
      if (n <= 0) println("Por favor, ingrese un número mayor que cero.")
    } while (n <= 0)

    var productOfMultiplesOf3 = 1
    var sumOfPositiveEvens = 0
    var lucasCount = 0

    for (i <- 1 to n) {
      var x = 0
      do {
        print("Dar un numero entero distinto de cero: ")
        x = readInt()
        if (x == 0) println("El número no puede ser cero.")
      } while (x == 0)

      if (x % 3 == 0) productOfMultiplesOf3 *= x
      if (x > 0 && x % 2 == 0) sumOfPositiveEvens += x
      if (isLucas(x)) {
        lucasCount += 1
        println(s"$x es de lucas en la posición $i")
      }
    }

    println(s"La suma de pares positivos: $sumOfPositiveEvens")
    println(s"Los numeros pares de lucas fueron: $lucasCount")
    println(if (productOfMultiplesOf3 != 1) s"El producto de los múltiplos de 3 es: $productOfMultiplesOf3"
    else "No hubo múltiplos de 3")
  }

  def isLucas(n: Int): Boolean = {
    if (n < 0) return false
    var a = 2
    var b = 1
    while (a < n) {
      val temp = a + b
      a = b
      b = temp
    }
    a == n
  }
}
