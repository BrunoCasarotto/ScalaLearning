object Solution {
    def maxArea(height: Array[Int]): Int = {
        var left = 0
        var right = height.length - 1
        var maxWater = 0
        
        while (left < right) {
            // Calculate the current area
            // Width = right - left
            // Height = min(height[left], height[right])
            val currentArea = (right - left) * Math.min(height(left), height(right))
            
            // Update the maximum area if current is larger
            maxWater = Math.max(maxWater, currentArea)
            
            // Move the pointer that has the smaller height
            // This is optimal because:
            // 1. Moving the taller pointer would definitely decrease the height
            // 2. Moving the shorter pointer might increase the height
            if (height(left) < height(right)) {
                left += 1
            } else {
                right -= 1
            }
        }
        
        maxWater
    }
}