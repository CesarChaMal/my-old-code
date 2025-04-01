import scala.io.StdIn._

object EjemploRepeat extends App {
  var n = 0
  while (n <= 0) {
    print("Dar cantidad de numeros : ")
    n = readInt()
  }

  var count = 0
  var supap = 0.0
  var pm3 = 1.0
  var cluc = 0
  var hasMult3 = false

  def isLucas(x: Int): Boolean = {
    var p = 1
    var seg = 3
    while (p < x) {
      val sig = p + seg
      p = seg
      seg = sig
    }
    p == x
  }

  while (count < n) {
    var x = 0.0
    do {
      print("Dar un numero : ")
      x = readDouble()
      if (x != x.toInt) println("error numero decimal")
    } while (x != x.toInt)

    count += 1
    val xi = x.toInt

    if (xi > 0 && xi % 2 == 0) supap += xi
    if (xi != 0 && xi % 3 == 0) {
      pm3 *= xi
      hasMult3 = true
    }

    if (xi > 0 && isLucas(xi)) {
      cluc += 1
      println(f"$x%.2f es de lucas")
      println(s"En la posicion : $count")
    }
  }

  println(f"La suma de pares positivos : $supap%.2f")
  println(s"Los numeros pares de lucas fueron : $cluc")
  if (hasMult3)
    println(f"El producto de los multiplos de 3 es : $pm3%.2f")
  else
    println("No hubo producto de multiplos de 3")
}
