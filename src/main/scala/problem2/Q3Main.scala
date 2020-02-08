package problem2

object Q3Main extends App {

  import DemoPromotions.allPromotions

  val allCombinations = Q1.allCombinablePromotions(allPromotions)
  println()
  println("---------------------------")
  println("All promotion combinations:")
  println("---------------------------")
  allCombinations.foreach(println)
  println("===========================")

  val allCombinationsForP1 = Q2.combinablePromotions("P1", allPromotions)
  println()
  println("----------------------------------")
  println("All promotion combinations for P1:")
  println("----------------------------------")
  allCombinationsForP1.foreach(println)
  println("==================================")

  val allCombinationsForP3 = Q2.combinablePromotions("P3", allPromotions)
  println()
  println("----------------------------------")
  println("All promotion combinations for P3:")
  println("----------------------------------")
  allCombinationsForP3.foreach(println)
  println("==================================")

}
