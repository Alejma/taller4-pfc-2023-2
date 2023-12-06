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


  val matriz4: Matriz = Vector(
    Vector(79, -75, 65, 20),
    Vector(37, 42, 50, 60),
    Vector(-45, 63, 31, 62),
    Vector(-10, 98, -97, -4)
  )


  val matriz5: Matriz = Vector(
    Vector(-43, 51, -85, -29),
    Vector(7, -15, -13, -49),
    Vector(12, 26, 41, 35),
    Vector(85, 62, 87, -83)
  )

  val matriz6: Matriz = Vector(
    Vector(-40, 94, -63, 16, -33, -60, -71, -52),
    Vector(-44, -8, 34, 70, -67, 4, -41, 61),
    Vector(2, -31, 69, 10, 12, -2, -45, -19),
    Vector(87, 29, 16, -85, 95, -56, 23, -3),
    Vector(85, -8, 64, -89, -10, 37, -31, -15),
    Vector(-43, 54, 29, -97, -99, -73, 44, 81),
    Vector(75, -47, 66, 4, 12, 36, 58, -20),
    Vector(4, 75, -22, -4, -65, -75, 87, 45)
  )
  val matriz7: Matriz = Vector(
    Vector(-92, -57, 67, 26, -44, 69, 36, -3),
    Vector(-60, 7, -13, -67, 15, -9, -62, 57),
    Vector(89, 15, 27, 19, -12, -89, 54, -20),
    Vector(-4, 50, -51, 64, -2, -10, 97, 77),
    Vector(66, 61, 2, 61, 65, -57, -27, 13),
    Vector(-88, -69, -14, -65, -86, -63, -30, 15),
    Vector(93, 78, 26, 1, -83, 81, -11, -94),
    Vector(-12, -44, -44, -60, -22, -56, -1, -68)
  )

  val matriz8: Matriz = Vector(
    Vector(58, -5, -89, -43, -74, -28, -52, 13),
    Vector(-29, 47, -52, -40, -50, 58, 17, 14),
    Vector(71, -94, 21, 79, -37, 74, 97, 8),
    Vector(-90, 31, 14, 40, -26, 28, 44, -36),
    Vector(-91, 40, -65, 92, 73, 55, 55, -94),
    Vector(33, -49, 10, -71, 36, -31, 81, 10),
    Vector(-24, 54, -58, 43, -39, -77, 5, -50),
    Vector(39, 62, 47, -69, 76, -64, -70, -85)
  )

  val matriz9: Matriz = Vector(
    Vector(25, -99, 87, 75, 0, -74, -28, -83),
    Vector(-34, -2, -30, 33, -86, 14, -66, 69),
    Vector(63, 83, -57, -7, -71, -77, -8, 93),
    Vector(68, -37, -54, -14, -8, 97, 0, -32),
    Vector(-61, 19, -43, -91, 23, 32, -44, 40),
    Vector(-25, -12, -74, -57, -78, 11, 14, 73),
    Vector(7, 94, -59, 86, 42, 65, -99, -66),
    Vector(-32, 48, 84, -32, 43, -33, -8, -8)
  )
  // Resultado de la multiplicación de las matrices de prueba
  val matrizF3: Matriz = Vector(
    Vector(250, 260, 270, 280),
    Vector(618, 644, 670, 696),
    Vector(986, 1028, 1070, 1112),
    Vector(1354, 1412, 1470, 1528)
  )

  val matrizF6: Matriz = Vector(
    Vector(-1442, 8084, -1335, 1999),
    Vector(4403, 6277, 3579, -6361),
    Vector(8018, 1410, 9671, -5843),
    Vector(-388, -4750, -4749, -7575)
  )
  val matrizF8: Matriz = Vector(
    Vector(-10508, 1670, -5203, -2575, 13946, 4663, -5594, 16851),
    Vector(-2045, -3783, -9436, -3530, -1370, -9860, 9617, 3281),
    Vector(4788, -600, 1608, 6037, 3704, -8963, 6940, 3265),
    Vector(5393, 2819, 11923, 4821, 5733, 5312, -7182, -7036),
    Vector(-7907, -13312, 11382, -3880, -5379, -2301, -2105, -4485),
    Vector(6695, -2720, 551, -16503, -3043, 4206, -8441, -16868),
    Vector(5036, 238, 9122, 6259, -11495, 2550, 7544, -7312),
    Vector(3051, 5783, 105, -7298, -4765, 14556, -3079, -8813)
  )

  val matrizF9: Matriz = Vector (
    Vector(-2477, -16862, 22005, 8852, 5950, -8165, 7326, -13736),
    Vector(-7048, 565, -778, 2558, -4388, 2609, -657, 3094),
    Vector(12496, -110, -5402, 8205, 3756, 5147, -2955, -15498),
    Vector(2644, 10108, -18292, -679, -6462, 13420, -2170, 8019),
    Vector(-3909, 1515, -28730, -8378, -3904, 30841, -6707, 5381),
    Vector(-2881, 9438, 4412, 6919, 11150, -5039, -7887, -9167),
    Vector(2773, -5884, 156, 9754, 2299, 11049, -1885, -8163),
    Vector(-3670, -5979, 1038, -960, -7972, -12347, -2190, 11288)
  )

  // Submatriz de pruebas A11
  val subMatrizA11P: Matriz = Vector(
    Vector(1, 2),
    Vector(5, 6),
  )
  val subMatrizA11H: Matriz = Vector(
    Vector(-40, 94),
    Vector(-44, -8),
  )
  val subMatrizA11F8: Matriz = Vector(
    Vector(58, -5),
    Vector(-29, 47)
  )
  // Submatriz de pruebas A22
  val subMatrizA22P: Matriz = Vector(
    Vector(6, 7, 8),
    Vector(10, 11, 12),
    Vector(14, 15, 16),
  )

  val subMatrizA22F: Matriz = Vector(
    Vector(42, 50, 60),
    Vector(63, 31, 62),
    Vector(98, -97, -4)
  )

val subMatrizA22X: Matriz = Vector(
    Vector(40, -26, 28),
    Vector(92, 73, 55),
    Vector(-71, 36, -31)
  )

  // Matrices de pruebas para suma
  val matrizSuma1: Matriz = Vector(
    Vector(18, 20, 22, 24),
    Vector(26, 28, 30, 32),
    Vector(34, 36, 38, 40),
    Vector(42, 44, 46, 48)
  )

  val matrizSuma2: Matriz = Vector(
    Vector(36, -24, -20, -9),
    Vector(44, 27, 37, 11),
    Vector(-33, 89, 72, 97),
    Vector(75, 160, -10, -87)
  )

  val matrizSuma3: Matriz = Vector(
    Vector(-132, 37, 4, 42, -77, 9, -35, -55),
    Vector(-104, -1, 21, 3, -52, -5, -103, 118),
    Vector(91, -16, 96, 29, 0, -91, 9, -39),
    Vector(83, 79, -35, -21, 93, -66, 120, 74),
    Vector(151, 53, 66, -28, 55, -20, -58, -2),
    Vector(-131, -15, 15, -162, -185, -136, 14, 96),
    Vector(168, 31, 92, 5, -71, 117, 47, -114),
    Vector(-8, 31, -66, -64, -87, -131, 86, -23)
  )

  val matrizSuma4: Matriz = Vector(
    Vector(83, -104, -2, 32, -74, -102, -80, -70),
    Vector(-63, 45, -82, -7, -136, 72, -49, 83),
    Vector(134, -11, -36, 72, -108, -3, 89, 101),
    Vector(-22, -6, -40, 26, -34, 125, 44, -68),
    Vector(-152, 59, -108, 1, 96, 87, 11, -54),
    Vector(8, -61, -64, -128, -42, -20, 95, 83),
    Vector(-17, 148, -117, 129, 3, -12, -94, -116),
    Vector(7, 110, 131, -101, 119, -97, -78, -93)
  )

  // Matrices de prueba para resta
  val matrizResta1: Matriz = Vector(
    Vector(-16, -16, -16, -16),
    Vector(-16, -16, -16, -16),
    Vector(-16, -16, -16, -16),
    Vector(-16, -16, -16, -16)
  )
  val matrizResta2: Matriz = Vector(
    Vector(122, -126, 150, 49),
    Vector(30, 57, 63, 109),
    Vector(-57, 37, -10, 27),
    Vector(-95, 36, -184, 79)
  )

  val matrizResta3: Matriz = Vector(
    Vector(52, 151, -130, -10, 11, -129, -107, -49),
    Vector(16, -15, 47, 137, -82, 13, 21, 4),
    Vector(-87, -46, 42, -9, 24, 87, -99, 1),
    Vector(91, -21, 67, -149, 97, -46, -74, -80),
    Vector(19, -69, 62, -150, -75, 94, -4, -28),
    Vector(45, 123, 43, -32, -13, -10, 74, 66),
    Vector(-18, -125, 40, 3, 95, -45, 69, 74),
    Vector(16, 119, 22, 56, -43, -19, 88, 113)
  )

  val matrizResta4: Matriz = Vector(
    Vector(33, 94, -176, -118, -74, 46, -24, 96),
    Vector(5, 49, -22, -73, 36, 44, 83, -55),
    Vector(8, -177, 78, 86, 34, 151, 105, -85),
    Vector(-158, 68, 68, 54, -18, -69, 44, -4),
    Vector(-30, 21, -22, 183, 50, 23, 99, -134),
    Vector(58, -37, 84, -14, 114, -42, 67, -63),
    Vector(-31, -40, 1, -43, -81, -142, 104, 16),
    Vector(71, 14, -37, -37, 33, -31, -62, -77)
  )



        test("1.1.1-mulMatrizSecuencial"){
            assert(matrizF3 == Taller4.mulMatriz(matriz1, matriz2))
            assert(matrizF6 == Taller4.mulMatriz(matriz4, matriz5))
            assert(matrizF8 == Taller4.mulMatriz(matriz6, matriz7))
            assert(matrizF9 == Taller4.mulMatriz(matriz8, matriz9))
        }

        test("1.1.2-mulMatrizParalelo"){
          assert(matrizF3 == Taller4.multMatrizParalelo(matriz1, matriz2))
          assert(matrizF6 == Taller4.multMatrizParalelo(matriz4, matriz5))
          assert(matrizF8 == Taller4.multMatrizParalelo(matriz6, matriz7))
          assert(matrizF9 == Taller4.multMatrizParalelo(matriz8, matriz9))
        }

        test("1.2.1-subMatriz"){
          val submatrizA11 = Taller4.subMatriz(matriz1, 0, 0, matriz1.length / 2)
          val submatrizA22 = Taller4.subMatriz(matriz1, (matriz1.length / 2) - 1, (matriz1.length / 2) - 1, 3)
          val submatrizA22P2 = Taller4.subMatriz(matriz4, (matriz4.length / 2) - 1, (matriz4.length / 2) - 1, 3)
          val subMatrizA11H4 = Taller4.subMatriz(matriz6, 0, 0, 2)
          val subMatriaA11J = Taller4.subMatriz(matriz8, 0, 0, 2)
          val subMatrizA22J = Taller4.subMatriz(matriz8, (matriz8.length / 2) - 1, (matriz8.length / 2) - 1, 3)
          assert(subMatrizA11P == submatrizA11 && subMatrizA22P == submatrizA22)
          assert(submatrizA22P2 == subMatrizA22F)
          assert(subMatrizA11H4 == subMatrizA11H)
          assert(subMatrizA22J == subMatrizA22X && subMatriaA11J == subMatrizA11F8)

        }

        test("1.2.2-sumMatriz"){
          val matrizSuma = Taller4.sumMatriz(matriz1, matriz2)
          val matrizSumaS = Taller4.sumMatriz(matriz4, matriz5)
          val matrizSumaM = Taller4.sumMatriz(matriz6, matriz7)
          assert(matrizSuma == matrizSuma1)
          assert(matrizSumaS == matrizSuma2)
          assert(matrizSumaM == matrizSuma3)
        }

        test("1.2.3-mulMatrizRecursivo"){
          val matrizMulMatrizRec = Taller4.multMatrizRec(matriz1, matriz2)
          val matrizMulMatrizRecS = Taller4.multMatrizRec(matriz4, matriz5)
          val matrizMulMatrizRecM = Taller4.multMatrizRec(matriz6, matriz7)
          val matrizMulMatrizRecN = Taller4.multMatrizRec(matriz8, matriz9)
          assert(matrizMulMatrizRec == matrizF3)
          assert(matrizMulMatrizRecS == matrizF6)
          assert(matrizMulMatrizRecM == matrizF8)
          assert(matrizMulMatrizRecN == matrizF9)
        }

        test("1.2.4-mulMatrizRecursivoParalelo"){
          val matrizMulMatrizRecPar = Taller4.multMatrizRecPar(matriz1, matriz2)
          val matrizMultiMatrizRecParS = Taller4.multMatrizRecPar(matriz4, matriz5)
          val matrizMulMatrizRecParM = Taller4.multMatrizRecPar(matriz6, matriz7)
          val matrizMulMatrizRecParN = Taller4.multMatrizRecPar(matriz8, matriz9)
          assert(matrizMulMatrizRecPar == matrizF3)
          assert(matrizMultiMatrizRecParS == matrizF6)
          assert(matrizMulMatrizRecParM == matrizF8)
          assert(matrizMulMatrizRecParN == matrizF9)
        }

        test("1.3.1-restaMatriz"){
          val matrizResta = Taller4.restaMatriz(matriz1, matriz2)
          val matrizRestaS = Taller4.restaMatriz(matriz4, matriz5)
          val matrizRestaM = Taller4.restaMatriz(matriz6, matriz7)
          val matrizRestaN = Taller4.restaMatriz(matriz8, matriz9)
          assert(matrizResta == matrizResta1)
          assert(matrizRestaS == matrizResta2)
          assert(matrizRestaM == matrizResta3)
          assert(matrizRestaN == matrizResta4)

        }

        test("1.3.2-multStrassen"){
          val matrizStrassen = Taller4.multStrassen(matriz1, matriz2)
          val matrizStrassenS = Taller4.multStrassen(matriz4, matriz5)
          val matrizStrassenM = Taller4.multStrassen(matriz6, matriz7)
          val matrizStrassenN = Taller4.multStrassen(matriz8, matriz9)
          assert(matrizStrassen == matrizF3)
          assert(matrizStrassenS == matrizF6)
          assert(matrizStrassenM == matrizF8)
          assert(matrizStrassenN == matrizF9)
        }

        test("1.3.3-multStrassenParalelo"){
          val matrizStrassenPar = Taller4.multStrassenPar(matriz1, matriz2)
          val matrizStrassenParS = Taller4.multStrassenPar(matriz4, matriz5)
          val matrizStrassenParM = Taller4.multStrassenPar(matriz6, matriz7)
          val matrizStrassenParN = Taller4.multStrassenPar(matriz8, matriz9)
          assert(matrizStrassenPar == matrizF3)
          assert(matrizStrassenParS == matrizF6)
          assert(matrizStrassenParM == matrizF8)
          assert(matrizStrassenParN == matrizF9)
        }
}
