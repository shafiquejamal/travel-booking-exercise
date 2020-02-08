package problem1

import scala.util.Try

object P1 {

  def havingLowestCabinPrice(prices: Seq[CabinPriceWithRateGroup]): Option[CabinPriceWithRateGroup] =
    prices.find(_.cabinPrice.price == prices.map(_.cabinPrice.price).min)


  def getBestGroupPrices(
      rates: Seq[Rate],
      prices: Seq[CabinPrice]): Seq[BestGroupPrice] = {

    val cabinPricesWithRateGroup = prices.flatMap{ price => // ignore prices that have a rate code with no corresponding rate group
      Try {
        CabinPriceWithRateGroup(price, rates.find( _.rateCode == price.rateCode).map(_.rateGroup).get)
      }.toOption
    }

    cabinPricesWithRateGroup
      .groupBy( price => (price.cabinPrice.cabinCode, price.rateGroup))
      .flatMap { case ((cabinCode, rateGroup), prices) =>
        havingLowestCabinPrice(prices)
          .map(price => BestGroupPrice(cabinCode, price.cabinPrice.rateCode, price.cabinPrice.price, rateGroup))
      }
    }.toSeq.sortWith(_.price < _.price)

}


case class CabinPriceWithRateGroup (cabinPrice: CabinPrice, rateGroup: String)


