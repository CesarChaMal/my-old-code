import scala.io.StdIn._

object Alg11_04 extends App {
  val (m, n) = Iterator.continually {
    print("Filas y columnas (max 25): ")
    (readInt(), readInt())
  }.find { case (x,y) => (1 to 25).contains(x) && (1 to 25).contains(y) }.get

  val arr = Array.tabulate(m, n) { (i, j) =>
    print(s"Elemento (${i+1},${j+1}): ")
    readDouble()
  }

  val pkfila = arr.last.product
  val menor = arr.flatten.min

  println(f"Producto fila $m: $pkfila%.2f")
  println(f"Menor elemento: $menor%.2f")
}
