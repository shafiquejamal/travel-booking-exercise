package problem2

case class Promotion(code: String, notCombinableWith: Seq[String])

case class PromotionCombo(promotionCodes: Seq[String])

