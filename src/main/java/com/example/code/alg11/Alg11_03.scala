package com.example.code.alg11

import scala.io.StdIn._

object Alg11_03 extends App {
  var m, n = 0
  do {
    print("Filas (max 25): ")
    m = readInt()
    print("Columnas (max 25): ")
    n = readInt()
  } while (m < 1 || m > 25 || n < 1 || n > 25)

  val arr = Array.ofDim[Double](m, n)
  for (i <- 0 until m; j <- 0 until n) {
    print(s"Elemento (${i+1},${j+1}): ")
    arr(i)(j) = readDouble()
  }

  val pkfila = arr(m - 1).product
  val menor = arr.flatten.min

  println(f"Producto fila $m: $pkfila%.2f")
  println(f"Menor elemento: $menor%.2f")
}
