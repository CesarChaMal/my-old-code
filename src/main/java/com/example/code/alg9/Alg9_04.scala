// Scala Functional Version
import scala.io.StdIn._

object Alg9_04 extends App {
  val L = Iterator.continually({
    print("Dar el orden del arreglo (max 50): ")
    readInt()
  }).find(n => n > 0 && n <= 50).get

  val arr = (1 to L).map { i =>
    print(s"Elemento $i: ")
    readInt()
  }.toList

  val pm3 = arr.filter(x => x % 3 == 0 && x != 0)
    .map(_.toDouble)
    .reduceOption(_ * _)

  val piep = arr.zipWithIndex
    .filter { case (v, i) => i % 2 == 0 && v % 2 == 0 && v != 0 }
    .map(_._1.toDouble)
    .reduceOption(_ * _)

  val sorted = arr.sorted

  println("\n--- Functional ---")
  println("Producto de multiplos de 3: " + pm3.getOrElse("No hubo"))
  println("Producto de posicion impar, valor par: " + piep.getOrElse("No hubo"))
  println("Arreglo ordenado: " + sorted.mkString(", "))
}
