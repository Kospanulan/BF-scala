import scala.collection.mutable.ListBuffer

object Solution {
    def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        var res = ListBuffer[Int]()
        
        // var nums = if (nums1.length < nums2.length) nums1 else nums2
        for(x <- nums1){
            if(nums2.contains(x) && !res.contains(x)){
                res += x
            }
        }
        
        return res.toArray
    }
}
