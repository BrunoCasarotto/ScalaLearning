object Solution {
    def triangleType(nums: Array[Int]): String = {
        if (!isValidTriangle(nums)) {
            return "none"
        }
        
        val distinctSides = nums.toSet.size
        
        distinctSides match {
            case 1 => "equilateral"
            case 2 => "isosceles"
            case 3 => "scalene"
        }
    }
    
    private def isValidTriangle(sides: Array[Int]): Boolean = {
        sides(0) + sides(1) > sides(2) &&
        sides(0) + sides(2) > sides(1) &&
        sides(1) + sides(2) > sides(0)
    }
}