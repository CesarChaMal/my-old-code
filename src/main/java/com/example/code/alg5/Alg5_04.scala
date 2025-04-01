import scala.io.StdIn._

object Alg5_04 extends App {
  def readIntPrompt(msg: String): Int = Iterator.continually {
    print(msg); readLine().toIntOption.getOrElse(0)
  }.find(_ != 0).get

  def isLucas(n: Int): Boolean = {
    if (n < 0) false
    else {
      LazyList.iterate((2, 1)) { case (a, b) => (b, a + b) }
        .map(_._1)
        .takeWhile(_ <= n)
        .contains(n)
    }
  }

  val n = Iterator.continually(readIntPrompt("Dar cantidad de numeros: "))
    .find(_ > 0).get

  val numbers = (1 to n).map(_ => readIntPrompt("Dar un numero: "))

  val product3 = numbers.filter(_ % 3 == 0).product
  val has3 = numbers.exists(_ % 3 == 0)
  val sumEvenPos = numbers.filter(x => x > 0 && x % 2 == 0).sum
  val lucasEvenCount = numbers.count(x => x % 2 == 0 && isLucas(x))

  println(s"La suma de pares positivos: $sumEvenPos")
  println(s"Los numeros pares de lucas fueron: $lucasEvenCount")
  println(if (has3) s"El producto de los múltiplos de 3 es: $product3" else "No hubo múltiplos de 3")
}
