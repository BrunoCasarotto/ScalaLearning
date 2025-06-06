object Solution {
    def maxArea(height: Array[Int]): Int = {
        var left = 0
        var right = height.length - 1
        var maxWater = 0
        
        while (left < right) {
            val currentArea = (right - left) * Math.min(height(left), height(right))
            
            maxWater = Math.max(maxWater, currentArea)
            
            if (height(left) < height(right)) {
                left += 1
            } else {
                right -= 1
            }
        }
        
        maxWater
    }
}