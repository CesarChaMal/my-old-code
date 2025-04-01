import scala.io.StdIn._

object Alg8_03 extends App {
  var n = 0
  do {
    println("Dar el orden del arreglo (max 50): ");
    n = readInt()
  } while (n <= 0 || n > 50)

  println("Dar los elementos uno a uno:")
  val arr = Array.fill(n)(readDouble())
  var max = arr(0)
  var posMax = 1
  var ppp, pei = 1.0
  var hasPpp, hasPei = false

  for (i <- arr.indices) {
    if (arr(i) > max) {
      max = arr(i)
      posMax = i + 1
    }
    if ((i + 1) % 2 == 0 && arr(i) != 0) { ppp *= arr(i); hasPpp = true }
    if (arr(i) % 2 != 0) { pei *= arr(i); hasPei = true }
  }

  println(f"El mayor = $max%.2f su posicion es $posMax")
  println(if (hasPpp) s"Producto de posicion de pares $ppp" else "No hubo producto positivo de pares")
  println(if (hasPei) s"Producto de elementos impares $pei" else "No hubo producto de elementos impares")
}
