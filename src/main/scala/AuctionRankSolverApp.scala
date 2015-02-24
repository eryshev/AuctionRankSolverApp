/**
 * Created by eryshev-alexey on 2/23/15.
 * An simple auction second-price winner determiner app
 * first arg is reserve price
 * second arg is JSON file path depending on current directory
 * that file consist of bids
 * {
  "A" : [110, 130],
  "B" : [0],
  "C" : [125],
  "D" : [105, 115, 90],
  "E" : [132, 135, 140]
  }
 */

import scala.util.parsing.json._

object AuctionRankSolverApp {

  def main(args: Array[String]) {
    println("AuctionRankSolver")

    val path = System.getProperty("user.dir")
    val reservePrice = args(0).toDouble
    val fileBids = args(1)
    val fileContent = io.Source.fromFile(s"$path/$fileBids").mkString
    val maybeBids = JSON.parseFull(fileContent).map(_.asInstanceOf[Map[String, List[Double]]])

    maybeBids match {
      case None => println("File isn't valid JSON or not existed")
      case Some(bids) =>
        val winner = AuctionRankSolver.solve(bids, reservePrice)
        println(s"(bidder,price) : $winner")
    }
  }

}
