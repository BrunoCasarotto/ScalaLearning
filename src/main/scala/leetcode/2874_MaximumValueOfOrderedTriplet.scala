object Solution {
    def maximumTripletValue(nums: Array[Int]): Long = {
        val n = nums.length
        var maxValue: Long = 0
        var maxNum = 0
        var maxDiff = 0
        
        for (k <- 0 until n) {
            maxValue = math.max(maxValue, maxDiff.toLong * nums(k).toLong)
            maxDiff = math.max(maxDiff, maxNum - nums(k))
            maxNum = math.max(maxNum, nums(k))
        }
        
        maxValue
    }
}