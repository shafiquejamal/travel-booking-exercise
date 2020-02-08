package problem2

import org.scalatest.{FlatSpecLike, Matchers}
import org.scalatest.LoneElement._


class Q2UTest extends FlatSpecLike with Matchers {

  import DemoPromotions.allPromotions

  "Finding all possible promotion combinations that contain a specified promotion code" should "do so, using the " +
  "method specified in the task" in {
    val expectedForP1 = Seq(
      PromotionCombo(Seq("P1", "P5")),
      PromotionCombo(Seq("P1", "P4")),
      PromotionCombo(Seq("P1", "P4", "P5")),
      PromotionCombo(Seq("P1", "P2"))
    )
    Q2.combinablePromotions("P1", allPromotions) should contain theSameElementsAs expectedForP1

    val expectedForP3 = Seq(
      PromotionCombo(Seq("P3", "P5")),
      PromotionCombo(Seq("P3", "P4")),
      PromotionCombo(Seq("P3", "P4", "P5")),
      PromotionCombo(Seq("P2", "P3"))
    )
    Q2.combinablePromotions("P3", allPromotions) should contain theSameElementsAs expectedForP3
  }
}
