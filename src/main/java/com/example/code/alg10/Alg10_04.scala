import scala.io.StdIn._

object Alg10_04 extends App {
  println("Filas y Columnas (max 25):")
  val (m,n) = Iterator.continually((readInt(), readInt())).find{case(m,n)=> m>0 && n>0 && m<=25 && n<=25}.get
  println("Elementos por columnas:")
  val matrix = Array.tabulate(m,n)((f,c)=> readDouble())

  val prodOdd = matrix.zipWithIndex
    .collect{case (row,f) if f%2==0 => row.filter(_!=0).product}
    .product

  println(s"Producto filas impares: $prodOdd")

  if(m==n) println(s"Producto diagonal: ${matrix.indices.map(i=>matrix(i)(i)).filter(_!=0).product}")
  else println(s"Suma penultima fila: ${matrix(m-2).sum}")
}
