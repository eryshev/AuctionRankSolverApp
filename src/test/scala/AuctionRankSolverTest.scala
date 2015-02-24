/**
 * Created by eryshev-alexey on 2/23/15.
 */

import org.scalatest.{MustMatchers, FlatSpec}

class AuctionRankSolverTest extends FlatSpec with MustMatchers {

  "An good auction" should "give (E, 130.0)" in {
    AuctionRankSolver.solve(Map(
      "A" -> List(110, 130),
      "B" -> List(0),
      "C" -> List(125),
      "D" -> List(105, 115, 90),
      "E" -> List(132, 135, 140)),
      100
    ) mustBe("E", 130.0)
  }

  "An good auction with reserved price 125" should "give (E, 130.0)" in {
    AuctionRankSolver.solve(Map(
      "A" -> List(110, 130),
      "B" -> List(0),
      "C" -> List(125),
      "D" -> List(105, 115, 90),
      "E" -> List(132, 135, 140)),
      125
    ) mustBe("E", 130.0)
  }

  "An bad auction" should "give an exception" in {
    intercept[Exception] {
      AuctionRankSolver.solve(Map(
        "A" -> List(),
        "B" -> List(),
        "C" -> List(),
        "D" -> List(),
        "E" -> List()),
        100
      ) mustBe("E", 130.0)
    }
  }

  "An auction with empty map" should "give an exception" in {
    intercept[AssertionError] {
      AuctionRankSolver.solve(Map(),
        100
      ) mustBe("E", 130.0)
    }
  }

  "An good auction with high reserve price" should "give an exception" in {
    intercept[Exception] {
      AuctionRankSolver.solve(Map(
        "A" -> List(110, 130),
        "B" -> List(0),
        "C" -> List(125),
        "D" -> List(105, 115, 90),
        "E" -> List(132, 135, 140)),
        150
      ) mustBe("E", 130.0)
    }
  }

}