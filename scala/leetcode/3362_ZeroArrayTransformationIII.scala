object Solution {
    def maxRemoval(nums: Array[Int], queries: Array[Array[Int]]): Int = {
        val n = nums.length
        
        val coverage = new Array[Int](n)
        
        for (query <- queries) {
            val left = query(0)
            val right = query(1)
            for (i <- left to right) {
                coverage(i) += 1
            }
        }
        
        for (i <- 0 until n) {
            if (nums(i) > coverage(i)) {
                return -1
            }
        }
        
        val remaining = nums.clone()
        
        var necessaryCount = 0
        val sortedQueryIndices = queries.indices.sortBy(i => 
            queries(i)(1) - queries(i)(0) + 1
        )
        
        for (queryIdx <- sortedQueryIndices) {
            val query = queries(queryIdx)
            val left = query(0)
            val right = query(1)
            
            val isHelpful = (left to right).exists(i => remaining(i) > 0)
            
            if (isHelpful) {
                necessaryCount += 1
                
                for (i <- left to right) {
                    if (remaining(i) > 0) {
                        remaining(i) -= 1
                    }
                }
            }
        }
        
        queries.length - necessaryCount
    }
}