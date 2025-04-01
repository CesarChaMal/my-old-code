import scala.io.StdIn._

object Alg10_03 extends App {
  println("Filas y Columnas (max 25):")
  val m = readInt()
  val n = readInt()
  val a = Array.ofDim[Double](m,n)

  println("Elementos por columnas:")
  for (c <- 0 until n; f <- 0 until m)
    a(f)(c) = readDouble()

  var prodOdd = 1.0
  var hasProd = false
  for (f <- 0 until m by 2; c <- 0 until n if a(f)(c)!=0) {
    prodOdd *= a(f)(c)
    hasProd = true
  }

  println(if(hasProd) s"Producto filas impares: $prodOdd" else "No hay producto")

  if(m==n){
    val pd = (0 until m).map(i => a(i)(i)).filter(_!=0).product
    println(s"Producto diagonal: $pd")
  } else {
    val spf = a(m-2).sum
    println(s"Suma penultima fila: $spf")
  }
}
