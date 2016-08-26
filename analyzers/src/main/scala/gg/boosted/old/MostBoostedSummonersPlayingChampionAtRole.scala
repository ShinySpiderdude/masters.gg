package gg.boosted.old


object MostBoostedSummonersPlayingChampionAtRole  {

//  val log = LoggerFactory.getLogger("gg.boosted.MostBoostedSummonersPlayingChampionAtRole")
//
//
//  type SummonerChampionRoleToWinrate = ((Long, Int, Role), (Float))
//
//  type ChroleToSummonerWinrate = ((Int, Role), (Long, Float))
//
//  val MIN_GAMES_WITH_CHROLE = 1
//
//
//  //Convert an rdd of type SummonerGame to an rdd of (summonerId, championId, Role) => (winRate)
//
//  def summonerChampionRoleToWinrate(rdd: RDD[SummonerMatch], minGamesWithChrole:Int, playedSince: Long): RDD[SummonerChampionRoleToWinrate] = {
//
//    //Filter only for games played from at least the given date
//    val timeFilteredMap = rdd.filter(game => game.date > playedSince)
//
//    //Convert to a map of (summonerId, champion, role) => (wins, totalGames)
//    //So we can calculate wins/totalGame later
//    val intermediateMap = timeFilteredMap.map(game => {
//      game.winner match {
//        case false => ((game.summonerId, game.championId, game.role), (0, 1))
//        case true => ((game.summonerId, game.championId, game.role), (1, 1))
//      }
//    })
//
//    //This will give us a map of summonerChrole -> (wins, total games)
//    val reduced = intermediateMap.reduceByKey((x, y) => ((x._1 + y._1), (x._2 + y._2)))
//
//    //We are interested only in summoners that played that chrole more than ${min_games_with_chrole} times
//    val filtered = reduced.filter(_._2._2 >= minGamesWithChrole)
//
//    //Finally we get the ratio map
//    val summonerChampionRoleToWinRatioMap = filtered.mapValues(x => x._1.toFloat/x._2)
//
//    return summonerChampionRoleToWinRatioMap
//
//  }
//
//  //This will convert the rdd to an rdd of (summonerId, winrate)
//  def championRoleToHighestWinrateSummoner(rdd: RDD[SummonerChampionRoleToWinrate], championId:Int, role: Role):RDD[(Long, Float)] = {
//
//    //Get only the chrole we want from this list
//    //._1._2 is the championId for this rdd and ._1._3 is the role
//    val filteredChrole = rdd.filter(line => line._1._2 == championId && line._1._3 == role)
//
//    val summonerIdToWinrateSorted = filteredChrole.map(line => (line._2, line._1._1)).sortByKey(false).map(_.swap)
//
//    return summonerIdToWinrateSorted
//  }
//
//  def main(args: Array[String]) {
//
//    run()
//  }
//
//  def run(): Unit = {
//      val ssc = new StreamingContext("local[*]", "MostBoostedSummonersPlayingChampionAtRole", Seconds(1))
//
//      val messages = Utilities.getKafkaSparkContext(ssc)
//
//      log.info("Let's get rolling!")
//
//      val result = messages.map(_._2).window(Seconds(10), Seconds(1))
//              .map(SummonerMatch(_))
//              .transform ( rdd => summonerChampionRoleToWinrate(rdd, MIN_GAMES_WITH_CHROLE, 0))
//
//      result.foreachRDD(rdd => {
//        rdd.foreach(println)
//        println("-----")
//      })
//
//
//      //ssc.checkpoint("/tmp")
//      ssc.start()
//      ssc.awaitTermination()
//  }

}