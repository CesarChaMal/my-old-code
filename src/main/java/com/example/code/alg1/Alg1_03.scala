import scala.io.StdIn._

object Alg1_03 extends App {
  println("Dar dos valores : ")
  val a = scala.io.StdIn.readDouble()
  val b = scala.io.StdIn.readDouble()

  val suma = a + b
  val prod = a * b
  val sumacua = a * a + b * b

  println(f"La suma es : $suma%.2f")
  println(f"El producto es : $prod%.2f")
  println(f"La suma de los cuadrados es : $sumacua%.2f")
}
