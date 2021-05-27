object Solution extends App {
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    
    for(i <- 0 to pieces.length-1){
      if(!arr.contains(pieces(i)(0))) return false
      var ind = arr.indexOf(pieces(i)(0))
      
      for(j <- 1 to pieces(i).length-1){
        val x = pieces(i)(j)
        if(!arr.contains(x)) return false
        if(ind+1 != arr.indexOf(x)) return false
        ind+=1
        
      }
    }
    return true
  }
  
//   var arr = Array(91,4,64,78)
//   var pieces = Array(Array(78), Array(4,64), Array(91))
  
//   println(canFormArray(arr, pieces))
}
