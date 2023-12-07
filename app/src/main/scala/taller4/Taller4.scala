/**
  * Taller 3 - Programación Funcional
  * Autores: <Estudiantes>
  * Profesor: Carlos A Delgado
  */
package taller4

import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import common._
import scala.util.Random
object Taller4 {
  type Matriz = Vector[Vector[Int]]

  // Funcion que crea una matriz de dimensiones long x long con valores aleatorios entre 0 y vals
  def matrizAlAzar(long: Int, vals: Int): Matriz = {

    val random = new Random()
    val v = Vector.fill(long, long)(random.nextInt(vals))
    v
  }

  // Funcion que compara dos algoritmos y devuelve el tiempo de ejecucion de cada uno y la aceleracion
  def compararAlgoritmos(funcion1: (Matriz, Matriz) => Matriz, funcion2: (Matriz, Matriz) => Matriz)
                        (matriz1: Matriz, matriz2: Matriz): (Double, Double, Double) = {
    val tiempoFuncion1 = withWarmer(new Warmer.Default) measure {
      funcion1(matriz1, matriz2)
    }
    val tiempoFuncion2 = withWarmer(new Warmer.Default) measure {
      funcion2(matriz1, matriz2)
    }
    val tiempo1: Double = tiempoFuncion1.value
    val tiempo2: Double = tiempoFuncion2.value
    val aceleracion = tiempo1 / tiempo2
    (tiempo1, tiempo2, aceleracion)
  }

  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
    (v1 zip v2).map({ case (i, j) => i * j }).sum
  }

  def transpuesta(m: Matriz): Matriz = {
    val l = m.length
    Vector.tabulate(l, l)((i, j) => m(j)(i))
  }

  def mulMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val m2t = transpuesta(m2)
    val l = m1.length
    Vector.tabulate(l, l)((i, j) => prodPunto(m1(i), m2t(j)))
  }

  // Usando task multiplicar matrices de forma paralela
  def multMatrizParalelo(m1: Matriz, m2: Matriz): Matriz = {
    val m2t = transpuesta(m2)
    val (m1a, m1b) = m1.splitAt(m1.length / 2)

    val top = task(m1a.map(row => m2t.map(col => prodPunto(row, col))))
    val bot = task(m1b.map(row => m2t.map(col => prodPunto(row, col))))

    top.join() ++ bot.join()
  }

  // Funcion que obtiene la submatriz de una matriz
  def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
    Vector.tabulate(l, l)((f, c) => m(i + f)(j + c))
  }

  // Funcion que suma dos matrices
  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    Vector.tabulate(n, n) { (i, j) =>
      m1(i)(j) + m2(i)(j)
    }
  }

  // Funcion que multiplica dos matrices usando el algoritmo de divide y conquista
  def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length

    if (n == 1) {
      // Caso base: matrices de 1x1
      Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
      // Dividir y conquistar
      val m = n / 2

      // Submatrices de A
      val a11 = subMatriz(m1, 0, 0, m)
      val a12 = subMatriz(m1, 0, m, m)
      val a21 = subMatriz(m1, m, 0, m)
      val a22 = subMatriz(m1, m, m, m)

      // Submatrices de B
      val b11 = subMatriz(m2, 0, 0, m)
      val b12 = subMatriz(m2, 0, m, m)
      val b21 = subMatriz(m2, m, 0, m)
      val b22 = subMatriz(m2, m, m, m)

      // Calcula las submatrices intermedias
      val c11 = sumMatriz(multMatrizRec(a11, b11), multMatrizRec(a12, b21))
      val c12 = sumMatriz(multMatrizRec(a11, b12), multMatrizRec(a12, b22))
      val c21 = sumMatriz(multMatrizRec(a21, b11), multMatrizRec(a22, b21))
      val c22 = sumMatriz(multMatrizRec(a21, b12), multMatrizRec(a22, b22))

      // Combina las submatrices intermedias para obtener la matriz resultante
      Vector.tabulate(n, n) { (i, j) =>
        if (i < m && j < m) c11(i)(j)
        else if (i < m) c12(i)(j - m)
        else if (j < m) c21(i - m)(j)
        else c22(i - m)(j - m)
      }
    }
  }

  //Recuersion paralela
  def multMatrizRecPar(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length

    if (n == 1) {
      // Caso base: matrices de 1x1
      Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
      // Dividir y conquistar
      val m = n / 2

      // Submatrices de A
      val a11 = subMatriz(m1, 0, 0, m)
      val a12 = subMatriz(m1, 0, m, m)
      val a21 = subMatriz(m1, m, 0, m)
      val a22 = subMatriz(m1, m, m, m)

      // Submatrices de B
      val b11 = subMatriz(m2, 0, 0, m)
      val b12 = subMatriz(m2, 0, m, m)
      val b21 = subMatriz(m2, m, 0, m)
      val b22 = subMatriz(m2, m, m, m)

      // Calcula las submatrices intermedias
      val (c11, c12, c21, c22) = parallel(sumMatriz(multMatrizRecPar(a11, b11), multMatrizRecPar(a12, b21)),
        sumMatriz(multMatrizRecPar(a11, b12), multMatrizRecPar(a12, b22)),
        sumMatriz(multMatrizRecPar(a21, b11), multMatrizRecPar(a22, b21)),
        sumMatriz(multMatrizRecPar(a21, b12), multMatrizRecPar(a22, b22)))

      // Combina las submatrices intermedias para obtener la matriz resultante
      Vector.tabulate(n, n) { (i, j) =>
        if (i < m && j < m) c11(i)(j)
        else if (i < m) c12(i)(j - m)
        else if (j < m) c21(i - m)(j)
        else c22(i - m)(j - m)
      }
    }
  }

  // Otra funcion de sumar matrices para pruebas
  def sumarMatrices(m1: Matriz, m2: Matriz): Matriz = {
    Vector.tabulate(m1.size, m1.head.size) { (i, j) =>
      m1(i)(j) + m2(i)(j)
    }
  }

  // Funcion que resta dos matrices
  def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    Vector.tabulate(n, n) { (i, j) =>
      m1(i)(j) - m2(i)(j)
    }
  }

  // Funcion que multiplica dos matrices usando el algoritmo de Strassen
  def multStrassen(m1: Matriz, m2: Matriz): Matriz = {

    val n = m1.head.count(_ => true)

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
      val m = n / 2

      val a11 = subMatriz(m1, 0, 0, m)
      val a12 = subMatriz(m1, 0, m, m)
      val a21 = subMatriz(m1, m, 0, m)
      val a22 = subMatriz(m1, m, m, m)

      val b11 = subMatriz(m2, 0, 0, m)
      val b12 = subMatriz(m2, 0, m, m)
      val b21 = subMatriz(m2, m, 0, m)
      val b22 = subMatriz(m2, m, m, m)

      val p1 = multStrassen(sumMatriz(a11, a22), sumMatriz(b11, b22))
      val p2 = multStrassen(sumMatriz(a21, a22), b11)
      val p3 = multStrassen(a11, restaMatriz(b12, b22))
      val p4 = multStrassen(a22, restaMatriz(b21, b11))
      val p5 = multStrassen(sumMatriz(a11, a12), b22)
      val p6 = multStrassen(restaMatriz(a21, a11), sumMatriz(b11, b12))
      val p7 = multStrassen(restaMatriz(a12, a22), sumMatriz(b21, b22))

      val c11 = restaMatriz(sumMatriz(sumMatriz(p1, p4), p7), p5)
      val c12 = sumMatriz(p3, p5)
      val c21 = sumMatriz(p2, p4)
      val c22 = restaMatriz(sumMatriz(sumMatriz(p1, p3), p6), p2)

      // Construir la matriz resultante
      Vector.tabulate(n, n) { (i, j) =>
        if (i < m && j < m) c11(i)(j)
        else if (i < m && j >= m) c12(i)(j - m)
        else if (i >= m && j < m) c21(i - m)(j)
        else c22(i - m)(j - m)
      }
    }
  }

  // Funcion que multiplica dos matrices usando el algoritmo de Strassen de forma paralela
  def multStrassenPar(m1: Matriz, m2: Matriz): Matriz = {

    val n = m1.head.count(_ => true)

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
      val m = n / 2

      val a11 = task {
        subMatriz(m1, 0, 0, m)
      }
      val a12 = task {
        subMatriz(m1, 0, m, m)
      }
      val a21 = task {
        subMatriz(m1, m, 0, m)
      }
      val a22 = task {
        subMatriz(m1, m, m, m)
      }

      val b11 = task {
        subMatriz(m2, 0, 0, m)
      }
      val b12 = task {
        subMatriz(m2, 0, m, m)
      }
      val b21 = task {
        subMatriz(m2, m, 0, m)
      }
      val b22 = task {
        subMatriz(m2, m, m, m)
      }


      val p1 = task {
        multStrassenPar(sumMatriz(a11.join, a22.join), sumMatriz(b11.join, b22.join))
      }
      val p2 = task {
        multStrassenPar(sumMatriz(a21.join, a22.join), b11.join)
      }
      val p3 = task {
        multStrassenPar(a11.join, restaMatriz(b12.join, b22.join))
      }
      val p4 = task {
        multStrassenPar(a22.join, restaMatriz(b21.join, b11.join))
      }
      val p5 = task {
        multStrassenPar(sumMatriz(a11.join, a12.join), b22.join)
      }
      val p6 = task {
        multStrassenPar(restaMatriz(a21.join, a11.join), sumMatriz(b11.join, b12.join))
      }
      val p7 = task {
        multStrassenPar(restaMatriz(a12.join, a22.join), sumMatriz(b21.join, b22.join))
      }

      val c11 = restaMatriz(sumMatriz(sumMatriz(p1.join, p4.join), p7.join), p5.join)
      val c12 = sumMatriz(p3.join, p5.join)
      val c21 = sumMatriz(p2.join, p4.join)
      val c22 = restaMatriz(sumMatriz(sumMatriz(p1.join, p3.join), p6.join), p2.join)



      // Construir la matriz resultante
      Vector.tabulate(n, n) { (i, j) =>
        if (i < m && j < m) c11(i)(j)
        else if (i < m && j >= m) c12(i)(j - m)
        else if (i >= m && j < m) c21(i - m)(j)
        else c22(i - m)(j - m)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    // Pruebas para comparacion de algoritmos
/*    val dimensiones = Seq(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024)
    println("Comparativa entre multMatrizRec y multMatrizRecPar:")
    println("| Dimension | multMatrizRec | multMatrizRecPar | Aceleración |")
    println("|-----------|----------------|------------------|-------------|")

    for (dim <- dimensiones) {
      val matriz1 = matrizAlAzar(dim, 100)
      val matriz2 = matrizAlAzar(dim, 100)

      val (tiempoMultMatrizRec, tiempoMultMatrizRecPar, aceleracion) =
        compararAlgoritmos(multMatrizRec, multMatrizRecPar)(matriz1, matriz2)

      println(s"|     $dim     |   $tiempoMultMatrizRec   |      $tiempoMultMatrizRecPar       |    $aceleracion    |")
    }*/


    //mulMatriz(matriz4, matriz5).foreach(row => println(row.mkString(" ")))
  }
}
