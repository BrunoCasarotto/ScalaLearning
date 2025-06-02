object Solution {
    def candy(ratings: Array[Int]): Int = {
        val n = ratings.length
        if (n == 0) return 0
        if (n == 1) return 1
        
        // Initialize candies array where each child gets at least 1 candy
        val candies = Array.fill(n)(1)
        
        // First pass: left to right
        // Make sure each child with higher rating than left neighbor has more candies
        for (i <- 1 until n) {
            if (ratings(i) > ratings(i-1)) {
                candies(i) = candies(i-1) + 1
            }
        }
        
        // Second pass: right to left
        // Make sure each child with higher rating than right neighbor has more candies
        // Use max to avoid overriding the first pass results
        var totalCandies = candies(n-1)
        for (i <- (n-2) to 0 by -1) {
            if (ratings(i) > ratings(i+1)) {
                candies(i) = math.max(candies(i), candies(i+1) + 1)
            }
            totalCandies += candies(i)
        }
        
        totalCandies
    }
}