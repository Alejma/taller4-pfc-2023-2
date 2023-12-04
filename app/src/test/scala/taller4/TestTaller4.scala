/**
 * Plantilla para pruebas
* @author Carlos Delgado
* @version 1.0
* @note 22 de Noviembre de 2023 
 */
package taller4

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

import scala.collection.immutable.Vector

@RunWith(classOf[JUnitRunner])
class TestTaller4 extends AnyFunSuite{
    //Matricez de para pruebas
    type Matriz = Vector[Vector[Int]]
    val matriz1: Matriz = Vector(
      Vector(1, 2, 3, 4),
      Vector(5, 6, 7, 8),
      Vector(9, 10, 11, 12),
      Vector(13, 14, 15, 16)
    )
    val matriz2: Matriz = Vector(
      Vector(17, 18, 19, 20),
      Vector(21, 22, 23, 24),
      Vector(25, 26, 27, 28),
      Vector(29, 30, 31, 32)
    )
    val matriz3: Matriz = Vector(
      Vector(250, 260, 270, 280),
      Vector(618, 644, 670, 696),
      Vector(986, 1028, 1070, 1112),
      Vector(1354, 1412, 1470, 1528)
    )
   // Submatriz de pruebas A11
    val subMatrizA11P: Matriz = Vector(
      Vector(1, 2),
      Vector(5,6)

    )
  // Submatriz de pruebas A22
    val subMatrizA22P: Matriz = Vector(
      Vector(6, 7, 8),
      Vector(10, 11, 12),
      Vector(14, 15,16),
    )

    val matrizSuma: Matriz = Vector(
      Vector(18, 20, 22, 24),
      Vector(26, 28, 30, 32),
      Vector(34, 36, 38, 40),
      Vector(42, 44, 46, 48)
    )

    val matrizResta1: Matriz = Vector(
      Vector(-16, -16, -16, -16),
      Vector(-16, -16, -16, -16),
      Vector(-16, -16, -16, -16),
      Vector(-16, -16, -16, -16)
    )


        test("1.1.1-mulMatrizSecuencial"){
            assert(matriz3 == Taller4.mulMatriz(matriz1, matriz2))
        }

        test("1.1.2-mulMatrizParalelo"){
          assert(matriz3 == Taller4.multMatrizParalelo(matriz1, matriz2))
        }

        test("1.2.1-subMatriz"){
          val submatrizA11 = Taller4.subMatriz(matriz1, 0, 0, matriz1.length / 2)
          val submatrizA22 = Taller4.subMatriz(matriz1, (matriz1.length / 2) - 1, (matriz1.length / 2) - 1, 3)
          assert(subMatrizA11P == submatrizA11 && subMatrizA22P == submatrizA22)
        }

        test("1.2.2-sumMatriz"){
          val matrizSuma = Taller4.sumMatriz(matriz1, matriz2)
          assert(matrizSuma == matrizSuma)
        }

        test("1.2.3-mulMatrizRecursivo"){
          val matrizMulMatrizRec = Taller4.multMatrizRec(matriz1, matriz2)
          assert(matrizMulMatrizRec == matriz3)
        }

        test("1.2.4-mulMatrizRecursivoParalelo"){
          val matrizMulMatrizRecPar = Taller4.multMatrizRecPar(matriz1, matriz2)
          assert(matrizMulMatrizRecPar == matriz3)
        }

        test("1.3.1-restaMatriz"){
          val matrizResta = Taller4.restaMatriz(matriz1, matriz2)
          assert(matrizResta == matrizResta1)
        }

        test("1.3.2-multStrassen"){
          val matrizStrassen = Taller4.multStrassen(matriz1, matriz2)
          assert(matrizStrassen == matriz3)
        }

        test("1.3.3-multStrassenParalelo"){
          val matrizStrassenPar = Taller4.multStrassenPar(matriz1, matriz2)
          assert(matrizStrassenPar == matriz3)
        }
}
