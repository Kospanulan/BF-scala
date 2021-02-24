object Solution extends App{

  println("Problem 1")
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
    val length = candies.length
    val res = new Array[Boolean](length)
    for (i <- 0 until length) {
      if(candies(i) + extraCandies >= candies.max){
        res(i) = true
      }
      else{
        res(i) = false
      }
    }
    res
  }

  println(kidsWithCandies(Array(1, 2, 3, 4), 2).mkString(", "))




  println("Problem 2")
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x

    def add(x: Int): Unit = {
      var new_node = new ListNode()
      new_node.x = x
      new_node.next = null
      this.next = new_node
    }
  }

  def getDecimalValue(head: ListNode): Int = {
    var num = head.x
    while ( head.next != null ) {
      num = num * 2 + head.next.x
      head.x = head.next.x
      head.next = head.next.next
    }
    num
  }

  val list = new ListNode()
  list.x = 1
  list.add(0)
  list.next.add(1)

  println(getDecimalValue(list))







  println("Problem 3")
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    var cnt = 0
    val res = new Array[Int](nums.length)
    for (i <- 0 until nums.length){
      for (j <- 0 until nums.length) {
        if (nums(i) > nums(j)) {
          cnt += 1
        }
      }
      res(i) = cnt
      cnt = 0
    }
    res
  }

  println(smallerNumbersThanCurrent(Array(1, 2, 3, 4)).mkString(", "))




// ????????????????????????????????????????????????????????????????
  println("Problem 4")
  def repeatedNTimes(A: Array[Int]): Int = {
    var cnt = 0
    var max = 0
    var pos = 0
    var repeat: Array[Int] = new Array[Int](A.length)
    for (i <- 0 to A.length-1; j <- 0 to A.length-1){
      if(A(i) == A(j)){
        cnt += 1
      }
      if(j== A.length-1){
        repeat(i) = cnt - 1
        cnt = 0
      }
    }
    for (i <- 0 to repeat.length-1){
      if(repeat(i) > max){
        max = repeat(i)
        pos = i
      }
    }
    A(pos)

  }

  println(repeatedNTimes(Array(1, 2, 3, 4, 1, 4)))





  println("Problem 5")
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    var k = 0
    var cnt = 0
    for (i <- 0 to nums.length-1 by 2){
      cnt = cnt + nums(i)
    }

    var newArr: Array[Int] = new Array[Int](cnt)

    for (i <- 0 to nums.length-1 by 2){
      for (j <- 0 until nums(i)){
        newArr(k) = nums(i+1)
        k = k + 1
      }
    }
    newArr
  }

  println(decompressRLElist(Array(1, 2, 3, 4, 8, 6)).mkString(", "))




  println("Problem 6")
  def sumZero(n: Int): Array[Int] = {
    var newArr: Array[Int] = new Array[Int](n)
    var k = n
    if(n%2 == 0){
      for(i <- 0 to (n-1)/2){
        newArr(i) = -k
        newArr(n-i-1) = k
        k = k - 1
      }
    }
    else{
      for(i <- 0 until (n-1)/2){
        newArr(i) = -k
        newArr(n-i-1) = k
        k = k - 1
      }
      newArr((n-1)/2) = 0
    }
    newArr
  }
  println(sumZero(154).mkString(", "))





  println("Problem 7")
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    var newArr: Array[Int] = new Array[Int](mat.length)
    var output: Array[Int] = new Array[Int](k)
    var sum = 0
    var cnt = 0
    var min = 101
    var perm = -1
    for(i <- 0 to mat.length-1){
      for( j <- 0 to mat(0).length-1){
        sum = sum + mat(i)(j)
      }
      newArr(i) = sum
      sum = 0
    }
    while(cnt != k){
      for(i <- 0 to newArr.length-1){
        if(newArr(i) < min){
          min = newArr(i)
          perm = i
        }
      }
      newArr(perm) = 101
      output(cnt) = perm
      perm = -1
      min = 101
      cnt = cnt + 1
    }
    output
  }

  println(kWeakestRows(Array(Array(9,6,4,5),Array(1,5,6,8,4),Array(1, 2, 3, 4),Array(8, 6)), 4).mkString(", "))


  println("Problem 8")





}





