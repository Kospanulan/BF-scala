object Solution {
    def isAnagram(s: String, t: String): Boolean = {
        
        if(s.length() != t.length()){
            return false
        }
        
        for (a <- s){
            if(s.count(_ == a) != t.count(_ == a)){
                return false
            }
        }
        
        return true
    }
}
