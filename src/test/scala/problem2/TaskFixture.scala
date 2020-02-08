package problem2

trait TaskFixture {

  val p1 = Promotion("P1", Seq("P3"))
  val p2 = Promotion("P2", Seq("P4", "P5"))
  val p3 = Promotion("P3", Seq("P1"))
  val p4 = Promotion("P4", Seq("P2"))
  val p5 = Promotion("P5", Seq("P2"))
  val allPromotions = Seq(p1, p2, p3, p4, p5)

}
