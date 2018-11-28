import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object WordCount {
  def main(args: Array[String]) {
    val pathToFile = args(0)
    
    val conf = new SparkConf()
      .setAppName("WordCount")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)

    val wordsRdd = sc.textFile(pathToFile)
      .flatMap(_.split(" "))
    
    val lowerRdd = wordsRdd.map(x => x.toLowerCase)

    val wordCountsRdd = lowerRdd.map((_, 1)).reduceByKey(_ + _)

    val highFreqRdd = wordCountsRdd.filter(x => x._2 > 4)

    highFreqRdd.saveAsTextFile("wordcount")
  }
}

