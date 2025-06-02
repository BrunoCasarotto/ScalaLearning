object Solution {
    def maxRemoval(nums: Array[Int], queries: Array[Array[Int]]): Int = {
        val n = nums.length
        
        // Check if it's possible to zero the array with all queries
        val coverage = new Array[Int](n)
        
        // Calculate coverage without creating additional arrays
        for (query <- queries) {
            val left = query(0)
            val right = query(1)
            for (i <- left to right) {
                coverage(i) += 1
            }
        }
        
        // Check if solution is possible
        for (i <- 0 until n) {
            if (nums(i) > coverage(i)) {
                return -1
            }
        }
        
        // Track remaining decrements needed
        val remaining = nums.clone() // We need this array
        
        // Count necessary queries using sorted approach
        var necessaryCount = 0
        val sortedQueryIndices = queries.indices.sortBy(i => 
            queries(i)(1) - queries(i)(0) + 1
        )
        
        for (queryIdx <- sortedQueryIndices) {
            val query = queries(queryIdx)
            val left = query(0)
            val right = query(1)
            
            // Check if this query helps reduce any remaining values
            val isHelpful = (left to right).exists(i => remaining(i) > 0)
            
            if (isHelpful) {
                necessaryCount += 1
                
                // Apply the query where needed
                for (i <- left to right) {
                    if (remaining(i) > 0) {
                        remaining(i) -= 1
                    }
                }
            }
        }
        
        // Return the maximum number of queries that can be removed
        queries.length - necessaryCount
    }
}