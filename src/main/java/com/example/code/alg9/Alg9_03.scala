// Scala Procedural Version
import scala.io.StdIn._

object Alg9_03 extends App {
  var L = 0
  do {
    print("Dar el orden del arreglo (max 50): ")
    L = readInt()
  } while (L <= 0 || L > 50)

  val arr = new Array[Int](L)
  for (i <- 0 until L) {
    print(s"Elemento ${i + 1}: ")
    arr(i) = readInt()
  }

  var pm3 = 1.0
  var piep = 1.0
  var hasParImpar = false

  for (i <- arr.indices) {
    if ((i % 2 == 0) && arr(i) % 2 == 0 && arr(i) != 0) {
      piep *= arr(i)
      hasParImpar = true
    }
    if (arr(i) % 3 == 0 && arr(i) != 0) {
      pm3 *= arr(i)
    }
  }

  val sorted = arr.sorted

  println("\n--- Procedural ---")
  println("Producto de multiplos de 3: " + (if (pm3 != 1) pm3 else "No hubo"))
  println("Producto de posicion impar, valor par: " + (if (hasParImpar) piep else "No hubo"))
  println("Arreglo ordenado: " + sorted.mkString(", "))
}
