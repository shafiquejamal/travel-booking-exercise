package problem1

import org.scalatest._

class P1UTest extends FlatSpec with Matchers {

  "Finding the lowest price in a group of cabin prices" should "return the cabin price object that has the lowest " +
    "price" in {

    val cabinPrices = Seq(
      CabinPriceWithRateGroup(CabinPrice("C9", "M2", 99.999), "Military"),
      CabinPriceWithRateGroup(CabinPrice("C21", "M8", 99.998), "Military"),
      CabinPriceWithRateGroup(CabinPrice("C3", "S5", 100), "Senior")
    )

    P1.havingLowestCabinPrice(cabinPrices) should contain(
      CabinPriceWithRateGroup(CabinPrice("C21", "M8", 99.998), "Military"))
  }

  "Finding the lowest prices for each combination of rate group and cabin code" should "yield the " +
    "cabin code, price, rate code, and rate group corresponding to the lowest price for each combination" in {

    import DemoData.{cabinPrices, rates}

    P1.getBestGroupPrices(rates, cabinPrices) should contain theSameElementsInOrderAs(
      Seq(
        BestGroupPrice("CA", "M1", 200.00, "Military"),
        BestGroupPrice("CA", "S1", 225.00, "Senior"),
        BestGroupPrice("CB", "M1", 230.00, "Military"),
        BestGroupPrice("CB", "S1", 245.00, "Senior")
      )
    )
  }
}
