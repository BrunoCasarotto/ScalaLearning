object Solution {
    def candy(ratings: Array[Int]): Int = {
        val n = ratings.length
        if (n == 0) return 0
        if (n == 1) return 1
    
        val candies = Array.fill(n)(1)
        
        for (i <- 1 until n) {
            if (ratings(i) > ratings(i-1)) {
                candies(i) = candies(i-1) + 1
            }
        }
        
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