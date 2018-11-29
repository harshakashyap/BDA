object sort{
	def main(args:Array[String]){
		val ar = Array(6,2,8,5,1)
		sort(ar)
		print(ar)
		}
	def sort(a:Array[Int]){
		def swap(i:Int,j:Int){
			val t=a(i)
			a(i)=a(j)
			a(j)=t
		}
		def sort1(l:Int,r:Int){
			var pivot = a((l+r)/2)
			var i=l
			var j=r
			while(i<=j){
				while(a(i) < pivot){i+=1}
				while(a(j) > pivot){j-=1}
				if(i<=j){
					swap(i,j)
					i+=1
					j-=1
				}
			}
			if(l<j) sort1(l,j)
			if(j<r) sort1(i,r)
		}
		if(a.length>0)
		sort1(0 , a.length-1)
	}
}
