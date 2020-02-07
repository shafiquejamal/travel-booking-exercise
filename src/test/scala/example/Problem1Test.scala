package example

import org.scalatest._

class Problem1Test extends FlatSpec with Matchers {

  "Finding the lowest price in a group of cabin prices" should "return the cabin price object that has the lowest " +
    "price" in {

    val cabinPrices = Seq(
      CabinPriceWithRateGroup(CabinPrice("C9", "M2", 99.999), "Military"),
      CabinPriceWithRateGroup(CabinPrice("C21", "M8", 99.998), "Military"),
      CabinPriceWithRateGroup(CabinPrice("C3", "S5", 100), "Senior")
    )

    Problem1.havingLowestCabinPrice(cabinPrices) should contain(
      CabinPriceWithRateGroup(CabinPrice("C21", "M8", 99.998), "Military"))
  }

  "Finding the lowest prices for each combination of rate group and cabin code" should "yield the " +
    "cabin code, price, rate code, and rate group corresponding to the lowest price for each combination" in {

    val rates = Seq(Rate("M1", "Military"), Rate("M1", "Military"), Rate("S1", "Senior"), Rate("S2", "Senior"))
    val cabinPrices = Seq(
      CabinPrice("CA", "M1", 200.00),
      CabinPrice("CA", "M2", 250.00),
      CabinPrice("CA", "S1", 225.00),
      CabinPrice("CA", "S2", 260.00),
      CabinPrice("CB", "M1", 230.00),
      CabinPrice("CB", "M2", 260.00),
      CabinPrice("CB", "S1", 245.00),
      CabinPrice("CB", "S2", 270.00)
    )

    Problem1.getBestGroupPrices(rates, cabinPrices) should contain theSameElementsAs(
      Seq(
        BestGroupPrice("CA", "M1", 200.00, "Military"),
        BestGroupPrice("CA", "S1", 225.00, "Senior"),
        BestGroupPrice("CB", "M1", 230.00, "Military"),
        BestGroupPrice("CB", "S1", 245.00, "Senior")
      )
    )


  }
}
