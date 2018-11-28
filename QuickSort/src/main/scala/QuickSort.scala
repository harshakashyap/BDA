//import scala.collection.mutable._

object QuickSort{
	def sort(arr: List[Int]): List[Int] = {
		if(arr.length<2)
			arr
		else{
		val pivot = arr(arr.length/2)
		sort(arr.filter(_ < pivot)) ::: arr.filter(_ == pivot) ::: sort(arr.filter(_ >pivot))
		}
		//arr
	}
	
	def main(args: Array[String]) {
		var list = List(2,7,21,97,12,3,5,1221,44,6)
		print(sort(list))
		print(list)
	}
}
