import scala.io.StdIn._

object FunctionalEjemplo extends App {

  def readIntValue(prompt: String): Int = {
    print(prompt)
    readInt()
  }

  def readValidatedIntegers(n: Int): List[Int] = {
    def readOne(index: Int, acc: List[Int]): List[Int] = {
      if (index >= n) acc.reverse
      else {
        print("Dar un numero : ")
        val x = readDouble()
        if (x != x.toInt)
          println("error numero decimal")
        readOne(if (x == x.toInt) index + 1 else index,
          if (x == x.toInt) x.toInt :: acc else acc)
      }
    }

    readOne(0, Nil)
  }

  def isLucas(x: Int): Boolean = {
    LazyList.iterate((1, 3)) { case (a, b) => (b, a + b) }
      .map(_._1)
      .takeWhile(_ <= x)
      .contains(x)
  }

  val n = Iterator.continually(readIntValue("Dar cantidad de numeros : "))
    .dropWhile(_ <= 0).next()

  val inputs = readValidatedIntegers(n)

  val sumEvenPos = inputs.filter(i => i > 0 && i % 2 == 0).map(_.toDouble).sum

  val mult3List = inputs.filter(i => i != 0 && i % 3 == 0)
  val hasMult3 = mult3List.nonEmpty
  val prodMult3 = if (hasMult3) mult3List.map(_.toDouble).product else 1.0

  val evenLucas = inputs.zipWithIndex.collect {
    case (x, idx) if x > 0 && isLucas(x) =>
      println(f"$x%.2f es de lucas")
      println(s"En la posicion : ${idx + 1}")
      x
  }.count(_ % 2 == 0)

  println(f"La suma de pares positivos : $sumEvenPos%.2f")
  println(s"Los numeros pares de lucas fueron : $evenLucas")
  println(
    if (hasMult3) f"El producto de los multiplos de 3 es : $prodMult3%.2f"
    else "No hubo producto de multiplos de 3"
  )
}
