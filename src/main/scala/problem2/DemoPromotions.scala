package problem2

object DemoPromotions {

  val p1: Promotion = Promotion("P1", Seq("P3"))
  val p2: Promotion = Promotion("P2", Seq("P4", "P5"))
  val p3: Promotion = Promotion("P3", Seq("P1"))
  val p4: Promotion = Promotion("P4", Seq("P2"))
  val p5: Promotion = Promotion("P5", Seq("P2"))
  val allPromotions = Seq(p1, p2, p3, p4, p5)

}
