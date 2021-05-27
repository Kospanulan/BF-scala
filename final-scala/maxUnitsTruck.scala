object Solution extends App{
  def maximumUnits(val_boxTypes: Array[Array[Int]], truckSize: Int): Int = {
    var total = 0
    var cnt = truckSize
    var boxTypes = val_boxTypes
    boxTypes = boxTypes.sortWith(_(1) > _(1))
    
    for(i <- 0 to boxTypes.length-1){
      if (cnt < boxTypes(i)(0)){
        total += (cnt * boxTypes(i)(1))
        return total
      }
      total += (boxTypes(i)(0) * boxTypes(i)(1))
      cnt -= boxTypes(i)(0)
    }
    
    return total
  }
  
  var boxTypes = Array(Array(5, 10), Array(2, 5), Array(4, 7), Array(3, 9))
  var truckSize = 10
  
  println(maximumUnits(boxTypes, truckSize))
}
