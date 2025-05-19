object Solution {
    def triangleType(nums: Array[Int]): String = {
        // Check if it can form a triangle
        if (!isValidTriangle(nums)) {
            return "none"
        }
        
        // Count distinct sides
        val distinctSides = nums.toSet.size
        
        distinctSides match {
            case 1 => "equilateral" // All sides equal
            case 2 => "isosceles"   // Two sides equal
            case 3 => "scalene"     // All sides different
        }
    }
    
    private def isValidTriangle(sides: Array[Int]): Boolean = {
        sides(0) + sides(1) > sides(2) &&
        sides(0) + sides(2) > sides(1) &&
        sides(1) + sides(2) > sides(0)
    }
}