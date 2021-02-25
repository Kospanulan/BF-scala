//  https://www.geeksforgeeks.org/zellers-congruence-find-day-date/
object task3 extends App{
  def zelerConq(q: Int, m: Int, k: Int, j: Int) : Int = ( q + ( (13 * (m + 1)) / 5 ) + k + (k / 4) + (j / 4) + (5 * j) ) % 7
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    var m = month
    var y = year

    if (m == 1 || m == 2) {
      m +=12
      y -= 1
    }

    val h = zelerConq(day, m, y % 100, y / 100)

    h match {
      case 0 => "Saturday"
      case 1 => "Sunday"
      case 2 => "Monday"
      case 3 => "Tuesday"
      case 4 => "Wednesday"
      case 5 => "Thursday"
      case 6 => "Friday"
    }
  }

  case class Date(day: Int, month: Int, year: Int)

  val d = Date(31, 8, 2019)

  print(dayOfTheWeek(d.day, d.month, d.year))



}
