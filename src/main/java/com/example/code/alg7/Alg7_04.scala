object Alg7_04 extends App {
  def divisors(x: Int) = (2 to x/2).filter(x % _ == 0)

  val numbers = Iterator.continually{
    print("Dar un valor entero distinto de cero: "); scala.io.StdIn.readInt()
  }.filter(_ != 0).take({
    print("Dar cantidad de numeros: "); scala.io.StdIn.readInt()
  }).toList

  val evenProd = numbers.filter(x => x % 2 == 0 && !Set(2,4).contains(math.abs(x % 10))).product
  val maxOdd = numbers.filter(_ % 2 != 0).reduceOption(_ max _)

  numbers.filter(_ > 0).foreach{x =>
    val divs = divisors(x)
    divs.foreach(d => println(s"$d es divisor de $x"))
    println(s"$x tuvo ${divs.size} divisores")
  }

  println(if (evenProd != 1) s"El producto de pares es: $evenProd" else "No hubo producto de pares")
  println(maxOdd.fold("No se dieron impares")(x => s"El mayor de los impares es: $x"))
}
