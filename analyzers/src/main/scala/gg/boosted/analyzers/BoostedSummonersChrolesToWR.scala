package gg.boosted.analyzers

import gg.boosted.posos.{SummonerChrole, SummonerMatch}
import org.apache.spark.sql.{DataFrame, Dataset}

/**
  * Created by ilan on 8/26/16.
  */
object BoostedSummonersChrolesToWR {

    /**
      *
      * Calculate the Most boosted summoners at each role
      *
      * @param df of type [SummonerMatch]
      * @param gamesPlayed
      * @param since
      * @return df of type [SummonerChrole]
      */
    def calc(df: DataFrame, gamesPlayed:Int, since:Long):DataFrame = {
        df.createOrReplaceTempView("BoostedSummonersChrolesToWR_calc") ;
        df.sparkSession.sql(
            s"""
               |SELECT championId, roleId, summonerId, tier, region, count(*) as gamesPlayed, (sum(if (winner=true,1,0))/count(winner)) as winrate
               |FROM BoostedSummonersChrolesToWR_calc
               |WHERE date >= $since
               |GROUP BY championId, roleId, summonerId, tier, region
               |HAVING winrate > 0.5 AND gamesPlayed >= $gamesPlayed
               |ORDER BY winrate desc
      """.stripMargin)
    }

    /**
      * The basic idea is to run the above "calc" method, cache it, and then run it through this method
      * for each champion and role
      *
      * @param df of type [SummonerChrole]
      * @param championId
      * @param roleId
      * @return df of type [SummonerChrole], but filtered
      */
    def filterByChrole(df: DataFrame, championId:Int, roleId: Int):DataFrame = {
        df.filter(s"championId = $championId and roleId = $roleId")
    }

}