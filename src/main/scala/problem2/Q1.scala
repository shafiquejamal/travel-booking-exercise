package problem2

import scala.annotation.tailrec

object Q1 {

  def combinablePromotions(
      promotionCode: String,
      allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {

    val promotions = allPromotions.filterNot(promotion => !promotion.notCombinableWith.contains(promotionCode))

    val maybeRequiredPromotionCode = if (promotionCode.trim.isEmpty) None else Some(promotionCode)

    makeCombinations(promotions, maybeRequiredPromotionCode)
      .map { combinationOfPromotions => PromotionCombo(combinationOfPromotions.map(_.code)) }
  }

  private def isPowerOf2(n: Int) = (n & (n - 1)) == 0

  @tailrec
  def makeCombination(
      remainingPromotionsAndIsKeeps: Seq[(Promotion, Boolean)],
      accumulatedCombination: Seq[Promotion] = Seq(),
      accumulatedNotCombinableCodes: Seq[String] = Seq()): Seq[Promotion]  = {

    if (remainingPromotionsAndIsKeeps.isEmpty) {
      accumulatedCombination
    } else {
      val (currentPromotion, currentIsKeep) = remainingPromotionsAndIsKeeps.head
      if (currentIsKeep & !accumulatedNotCombinableCodes.contains(currentPromotion.code)) {
        val nextAccumulatedNotCombinableCodes =
          (accumulatedNotCombinableCodes ++ currentPromotion.notCombinableWith).distinct
        makeCombination(
          remainingPromotionsAndIsKeeps.tail,
          accumulatedCombination :+ currentPromotion, nextAccumulatedNotCombinableCodes)
      } else {
        makeCombination(remainingPromotionsAndIsKeeps.tail, accumulatedCombination, accumulatedNotCombinableCodes)
      }
    }
  }

  def makeCombinations(
      promotions: Seq[Promotion],
      maybeRequiredPromotionCode: Option[String] = None): Seq[Seq[Promotion]] = {

    val numberOfCombinations = scala.math.pow(2, promotions.length).toInt
    val lengthOfBinaryNumberOfCombinations = (numberOfCombinations - 1).toBinaryString.length

    @tailrec
    def make(index: Int, accumulatedCombinations: Seq[Seq[Promotion]] = Seq()): Seq[Seq[Promotion]] = {
      if (index >= numberOfCombinations) {
        accumulatedCombinations
      } else {
        if (isPowerOf2(index)) {
          make(index + 1, accumulatedCombinations)
        } else {
          val indexAsBinaryString = index.toBinaryString
          val leftPadding = Seq.fill(lengthOfBinaryNumberOfCombinations - indexAsBinaryString.length)("0").mkString
          val isKeeps: Seq[Boolean] = (leftPadding + indexAsBinaryString).map(_ == '1')
          val combinationsForThisIndex = makeCombination(promotions.zip(isKeeps))

          lazy val isCombinationDoesNotContainRequiredPromotionCode: Boolean =
            maybeRequiredPromotionCode.fold[Boolean](false){ requiredPromoCode =>
              combinationsForThisIndex.map(_.code).indexOf(requiredPromoCode) == -1
            }

          if (combinationsForThisIndex.length <= 1) {
            make(index + 1, accumulatedCombinations)
          } else if (isCombinationDoesNotContainRequiredPromotionCode) {
            make(index + 1, accumulatedCombinations)
          } else {
            make(index + 1, accumulatedCombinations :+ combinationsForThisIndex)
          }
        }
      }
    }

    make(index = 1).distinct
  }

}
