object Solution {
    def largestPerimeter(val_nums: Array[Int]): Int = {
        var nums = val_nums
        nums = nums.sortWith(_ > _)
        
        for(i <- 0 to nums.length-3){
            if(nums(i) < nums(i+1) + nums(i+2)){
                return (nums(i) + nums(i+1) + nums(i+2))
            }
        }
        
        return 0
    }
}
