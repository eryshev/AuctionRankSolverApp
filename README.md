AuctionRankSolverApp
====================

#RUN

There are 2 input arguments reserve price et JSON file with bids

    1) sbt "run 100 bids.json"
    2) sbt package => scala <project root/auctionranksolver_2.11-1.0.jar> <reserve price> <JSON file path relative depending on current directory>


#TEST

The tests are basing on ScalaTest framework

    1) sbt test