package problem2

import org.scalatest.{FlatSpecLike, Matchers}
import org.scalatest.LoneElement._

trait Fixture {

  val pA = Promotion("A", Seq("B", "C"))
  val pB = Promotion("B", Seq("A", "E"))
  val pC = Promotion("C", Seq("A"))
  val pD = Promotion("D", Seq())
  val pE = Promotion("E", Seq("B"))

  val promotions = Seq(pA, pB, pC, pD, pE)

}

class Q1UTest extends FlatSpecLike with Matchers {

  "Generating all combinations of promotions for a list of promotions, that include the first promotion," should
    "yield a list of valid combinations that are exhaustive and respect the 'notCombinableWith' restrictions" in new Fixture {
    val expectedCombinations = Seq(
      Seq(pD, pE),
      Seq(pC, pE),
      Seq(pC, pD),
      Seq(pC, pD, pE),
      Seq(pB, pD),
      Seq(pB, pC),
      Seq(pB, pC, pD),
      Seq(pA, pE),
      Seq(pA, pD),
      Seq(pA, pD, pE)
    )

    Q1.makeCombinations(promotions) should contain theSameElementsAs expectedCombinations
  }


  "Creating a combination based on an integer index to indicate whether to include a promotion" should "yield the " +
    "combination that reflects the integer specification" in new Fixture  {
    val expectedForIndex3 = Seq(pD, pE)
    val expectedForIndex15 = Seq(pA, pD, pE)

    Q1.makeCombination(promotions.zip(Seq(false, false, false, false, false))) shouldBe empty
    Q1.makeCombination(promotions.zip(Seq(false, false, false, false, true))).loneElement shouldBe pE
    Q1.makeCombination(promotions.zip(Seq(false, false, false, true, false))).loneElement shouldBe pD
    Q1.makeCombination(promotions.zip(Seq(false, false, false, true, true))) should contain theSameElementsInOrderAs expectedForIndex3
    Q1.makeCombination(promotions.zip(Seq(true, true, true, true, true))) should contain theSameElementsInOrderAs expectedForIndex15
  }



}
