object Solution extends App{
  def canMakeArithmeticProgression(val_arr: Array[Int]): Boolean = {
    var arr = val_arr
    arr = arr.sorted
    val q = arr(1) - arr(0)
    for(i <- 2 to arr.length-1){
      if(arr(i) - arr(i-1) != q){
        return false
      }
    }
    
    return true

  }
  
}
