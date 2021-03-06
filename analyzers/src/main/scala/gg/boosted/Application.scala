package gg.boosted

import gg.boosted.configuration.Configuration
import gg.boosted.services.MainsService
import org.apache.spark.sql.SparkSession

/**
  *
  * The entry point for this spark analyzer
  *
  * Created by ilan on 12/8/16.
  */
object Application {

  val checkPointDir = Configuration.getString("checkpoint.dir")

  private val master = "local[*]"
  private val appName = Configuration.getString("kafka.topic")

  val session:SparkSession = SparkSession
    .builder()
    .appName(appName)
    .master(master)
    .config("spark.cassandra.connection.host", Configuration.getString("cassandra.location"))
    .getOrCreate()
//
//
//  def context():StreamingContext = {
//    val ssc = new StreamingContext(session.sparkContext, Minutes(Configuration.getLong("calculate.every.n.minutes")))
//
//    val stream = KafkaUtil.getKafkaSparkContext(ssc).window(Minutes(Configuration.getLong("window.size.minutes"))).map(value => SummonerMatch(value._2))
//    MainsService.analyze(stream)
//
//    ssc.checkpoint(checkPointDir)
//    ssc
//  }

  def main(args: Array[String]): Unit = {

    MainsService.analyze()
    //val sc = session.read.cassandraFormat("SUMMONER_MATCHES", "BoostedGG").load()

//    val sc = session.read.format("org.apache.spark.sql.cassandra")
//      .options(Map( "table" -> "SUMMONER_MATCHES", "keyspace" -> "BoostedGG"))
//      .load()
    //AnalyzerService.analyze(sc.rdd.toDS())

    //val ssc = StreamingContext.getOrCreate(checkPointDir, context _)

    //ssc.start()
    //ssc.awaitTermination()
  }

}
