object Alg8_04 extends App {
  println("Dar el orden del arreglo (max 50): ");
  val n = Iterator.continually(io.StdIn.readInt()).find(x => x > 0 && x <= 50).get
  println("Dar los elementos uno a uno:")
  val arr = List.fill(n)(io.StdIn.readDouble())

  val (max, posMax) = arr.zipWithIndex.maxBy(_._1)

  val ppp = arr.zipWithIndex.collect { case (v, i) if (i+1)%2==0 && v!=0 => v }.product
  val hasPpp = arr.zipWithIndex.exists { case (v, i) => (i+1)%2==0 && v!=0 }

  val oddElems = arr.filter(_ % 2 != 0)
  val pei = oddElems.product
  val hasPei = oddElems.nonEmpty

  println(f"El mayor = $max%.2f su posicion es ${posMax+1}")
  println(if (hasPpp) s"Producto de posicion de pares $ppp" else "No hubo producto positivo de pares")
  println(if (hasPei) s"Producto de elementos impares $pei" else "No hubo producto de elementos impares")
}
