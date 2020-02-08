package problem2

import problem2.Q1.makeCombinations

object Q2 {

  def combinablePromotions(
      promotionCode: String,
      allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {

    val maybeRequiredPromotionCode = if (promotionCode.trim.isEmpty) None else Some(promotionCode)

    makeCombinations(allPromotions, maybeRequiredPromotionCode)
      .map { combinationOfPromotions => PromotionCombo(combinationOfPromotions.map(_.code)) }
  }


}
