import scala.io.Source

object scalaWordCount{
	def main(args: Array[String]) = {
		if(args.length!=1)
		{
			System.err.println("Wrong Usage")
			System.exit(0)
		}
		val filename = args(0)
		
		val wordcount = scala.collection.mutable.Map[String,Int]()
		for(line <- Source.fromFile(filename).getLines)
			for(word<-line.split(" "))
				wordcount(word) = if(wordcount.contains(word)) wordcount(word)+1 else 1
				
		for((k,v)<-wordcount)
			printf("\nWord %s occurs %d times",k,v)
	}
}
