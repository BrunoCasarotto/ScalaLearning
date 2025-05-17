object Solution {
    def isMatch(s: String, p: String): Boolean = {
        // Use memoization to cache results
        val memo = scala.collection.mutable.Map[(Int, Int), Boolean]()
        
        def dp(i: Int, j: Int): Boolean = {
            // Check if we've already computed this state
            if (memo.contains((i, j))) return memo((i, j))
            
            val result = if (j >= p.length) {
                // Pattern is exhausted, match only if string is also exhausted
                i >= s.length
            } else {
                // Check if current characters match
                val currentMatch = i < s.length && (p(j) == '.' || p(j) == s(i))
                
                // Check if next character in pattern is '*'
                if (j + 1 < p.length && p(j + 1) == '*') {
                    // Two cases:
                    // 1. Skip the '*' pattern (0 occurrences)
                    // 2. Use the '*' pattern if current characters match, and advance string
                    dp(i, j + 2) || (currentMatch && dp(i + 1, j))
                } else {
                    // No '*' - if current characters match, advance both string and pattern
                    currentMatch && dp(i + 1, j + 1)
                }
            }
            
            // Cache the result
            memo((i, j)) = result
            result
        }
        
        dp(0, 0)
    }
}