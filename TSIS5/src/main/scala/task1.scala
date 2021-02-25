object task1 extends App{
  def multipMinusOne(n1: Int, n2: Int) : Int = (n1 - 1) * (n2 - 1)
  def maxProduct(nums: Array[Int]): Int = {
    val x1 = nums.max
    if (nums.count(_==x1) >= 2){
      return multipMinusOne(x1, x1)
    }
    val nums2 = nums.filter(x1>_)
    val x2 = nums2.max
    multipMinusOne(x1, x2)
  }

  var nums = Array(3, 4, 5, 5)
  print(maxProduct(nums))
}
