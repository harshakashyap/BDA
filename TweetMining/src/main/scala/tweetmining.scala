package com.nmit.spark.tweetmining

import org.apache.spark.{SparkContext, SparkConf}

import org.apache.spark.rdd._

object tweetmining {

  def main(args: Array[String]) {
    if (args.length != 1) {
      println()
      println("Dude, I need exactly one argument.")
      println("But you have given me " + args.length +".")
      println("The argument should be path to json file containing a bunch of tweets. esired.")
      System.exit(1)
    }

    val pathToFile = args(0)

    val conf = new SparkConf()
      .setAppName("User mining")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)

    val tweets =
      sc.textFile(pathToFile).mapPartitions(TweetUtils.parseFromJson(_))

    println("For debug, a single tweet.")
    println("--------------------------")
    tweets.take(1).foreach{ case(tweet) => println(tweet.user) }

    val tweetsByUser = tweets.map(x => (x.user, x)).groupByKey()

    println("For debug, tweets grouped by user.")
    println("----------------------------------")
    tweetsByUser.filter(x => x._2.size > 1).take(1).foreach(x => {
      println("user --> ", x._1)
      println("tweet --> ", x._2)
    })

    val numTweetsByUser = tweetsByUser.map(x => (x._1, x._2.size))

    val sortedUsersByNumTweets = numTweetsByUser.sortBy(_._2, ascending=false)

    sortedUsersByNumTweets.take(10).foreach(println)

  }
}

import com.google.gson._

object TweetUtils {
  case class Tweet (
    id : String,
    user : String,
    userName : String,
    text : String,
    place : String,
    country : String,
    lang : String
  )

  def parseFromJson(lines:Iterator[String]):Iterator[Tweet] = {
    val gson = new Gson
    lines.map(line => gson.fromJson(line, classOf[Tweet]))
  }
}
