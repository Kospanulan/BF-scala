import scala.collection.mutable.ListBuffer

object Solution {
    def sortString(s: String): String = {
        var elems = ListBuffer[Char]()
        for(x <- s){
            elems += x
        }

        var res = ""
        while (elems.length != 0){
            var sorted: ListBuffer[Char] = elems.sorted
            var first = ""
            for(x <- sorted){
                if(!first.contains(x)){
                    first += x
                    elems -= x
                }
            }
            var second = ""
            var rev_sorted: ListBuffer[Char] = elems.sortWith(_ > _)
            for(x <- rev_sorted){
                if(!second.contains(x)){
                    second += x
                    elems -= x
                }
            }
            res += (first + second)
        }
        
        return res
    }
}
