/**
 * Created by eryshev-alexey on 2/23/15.
 */

class AuctionRankSolver {
  //TODO what can we do with the bidders with the same max bid?

  /**
   * An intuitive algorithm for solve second-price auction winner problem
   *
   * @param allBids - all bids in format Map("Bidder name" -> List( of bids ))
   * @param reservePrice - reserve price
   * @return ("Bidder name", Bid) or exception
   */
  def solve(allBids: Map[String, List[Double]], reservePrice: Double): (String, Double) = {
    assume(allBids.nonEmpty, "There isn't bids")

    val solution = allBids.foldRight((reservePrice, reservePrice, "")) {
      case ((bidder: String, bids: List[Double]), max) if bids.nonEmpty =>
        val maxBid = bids.max

        if (maxBid >= max._1) (maxBid, max._1, bidder)
        else if (maxBid > max._2) (max._1, maxBid, max._3)
        else max
      case (_, max) => max
    }

    solution match {
      case (first, second, bidder) if bidder != "" => bidder -> second
      case _ => throw new Exception("Max bid is less that reserve price or bids don't exist")
    }

  }
}

object AuctionRankSolver extends AuctionRankSolver
