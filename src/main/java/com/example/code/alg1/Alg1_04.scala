import scala.io.StdIn._

object Alg1_04 extends App {
  println("Dar dos valores : ")
  val a = scala.io.StdIn.readDouble()
  val b = scala.io.StdIn.readDouble()

  val suma = (x: Double, y: Double) => x + y
  val prod = (x: Double, y: Double) => x * y
  val sumacua = (x: Double, y: Double) => x * x + y * y

  println(f"La suma es : ${suma(a, b)}%.2f")
  println(f"El producto es : ${prod(a, b)}%.2f")
  println(f"La suma de los cuadrados es : ${sumacua(a, b)}%.2f")
}
