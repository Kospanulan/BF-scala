object task4 extends App{
  def findPairs(nums: Array[Int], k: Int): Int = {
    var pairs: List[List[Int]] = List()
    for(i <- 0 until nums.size-1; j <- i+1 until nums.size ){
      val x1 = nums(i)
      val x2 = nums(j)
      if(math.abs( x1 - x2) == k && !pairs.contains(List(x1, x2)) && !pairs.contains(List(x2, x1))) {
        pairs = pairs :+ List(x1, x2)
      }
    }
    pairs.size
  }
  
  print(findPairs(Array(1,3,1,4,1,5), 2))

}

