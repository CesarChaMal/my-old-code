import scala.io.StdIn._

object Alg4_04 extends App {
  def readIntWithPrompt(prompt: String): Int = {
    print(prompt)
    readInt()
  }

  val n = Iterator.continually(readIntWithPrompt("Dar cantidad de numeros: "))
    .find(_ > 0)
    .get

  val numbers = (1 to n).map { _ =>
    Iterator.continually(readIntWithPrompt("Dar un valor entero: "))
      .find(_ != 0)
      .get
  }

  val productEven = numbers.filter(_ % 2 == 0).product.toDouble
  val oddNumbers = numbers.filter(x => x % 2 != 0 && math.abs(x) % 10 != 3)
  val productOdd = if (oddNumbers.nonEmpty) Some(oddNumbers.product.toDouble) else None
  val min = numbers.min
  val max = numbers.max
  val positionMax = numbers.indexOf(max) + 1

  println(f"El producto de pares es: $productEven%.2f")
  productOdd match {
    case Some(value) => println(f"El producto de impares (excepto los terminados en 3) es: $value%.2f")
    case None        => println("No hay impares que no terminan en 3 para calcular el producto.")
  }
  println(s"El menor: $min")
  println(s"El mayor es: $max")
  println(s"La posicion del mayor es: $positionMax")
}
