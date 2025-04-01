import scala.io.StdIn._

object Alg4_03 extends App {
  var n = 0
  do {
    print("Dar cantidad de numeros: ")
    n = readInt()
  } while (n <= 0)

  var count = 0
  var productEven = 1.0
  var productOdd = 1.0
  var hasOdd = false
  var min = Int.MaxValue
  var max = Int.MinValue
  var positionMax = -1

  while (count < n) {
    var x = 0
    do {
      print("Dar un valor entero: ")
      x = readInt()
    } while (x == 0)
    count += 1

    if (x % 2 == 0) {
      productEven *= x
    } else if (math.abs(x) % 10 != 3) {
      productOdd *= x
      hasOdd = true
    }

    if (x < min) min = x
    if (x > max) {
      max = x
      positionMax = count
    }
  }

  println(f"El producto de pares es: $productEven%.2f")
  if (hasOdd) {
    println(f"El producto de impares (excepto los terminados en 3) es: $productOdd%.2f")
  } else {
    println("No hay impares que no terminan en 3 para calcular el producto.")
  }
  println(s"El menor: $min")
  println(s"El mayor es: $max")
  println(s"La posicion del mayor es: $positionMax")
}
