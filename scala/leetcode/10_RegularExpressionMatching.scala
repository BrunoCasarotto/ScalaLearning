object Solution {
    def isMatch(s: String, p: String): Boolean = {
        val memo = scala.collection.mutable.Map[(Int, Int), Boolean]()
        
        def dp(i: Int, j: Int): Boolean = {
            if (memo.contains((i, j))) return memo((i, j))
            
            val result = if (j >= p.length) {
                i >= s.length
            } else {
                val currentMatch = i < s.length && (p(j) == '.' || p(j) == s(i))
                
                if (j + 1 < p.length && p(j + 1) == '*') {
                    dp(i, j + 2) || (currentMatch && dp(i + 1, j))
                } else {
                    currentMatch && dp(i + 1, j + 1)
                }
            }
            
            memo((i, j)) = result
            result
        }
        
        dp(0, 0)
    }
}