object task2 extends App{
  def average(salary: Array[Int]): Double = {
    (salary.sum - salary.min - salary.max).toDouble / (salary.size-2).toDouble
  }

  val salary = Array(800, 150, 100, 250)
  print(average(salary))
}
