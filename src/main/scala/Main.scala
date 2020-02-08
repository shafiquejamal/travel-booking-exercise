import problem2.{DemoPromotions, Q1, Q2}
import problem1.P1

object Main extends App {

  import problem1.DemoData.{rates, cabinPrices}
  println()
  println("Problem 1")
  println()

  val bestCabinPrices = P1.getBestGroupPrices(rates, cabinPrices)
  println()
  println("------------------")
  println("Best cabin prices:")
  println("------------------")
  bestCabinPrices.foreach(println)
  println("==================")

  println()
  println("Problem 2")
  println()

  import problem2.DemoPromotions.allPromotions
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
