object Solution {
  def reverse(x: Int): Int = {
    // Special case: if x is 0, return 0
    if (x == 0) return 0
    
    // Get the sign of the number
    val sign = if (x < 0) -1 else 1
    
    // Convert to positive for processing (use Long to avoid immediate overflow)
    var num = math.abs(x.toLong)
    var result: Long = 0
    
    // Process each digit
    while (num > 0) {
      // Check for potential overflow before multiplying
      if (result > Int.MaxValue / 10) return 0
      
      // Shift digits left and add new digit
      result = result * 10 + (num % 10)
      num /= 10
    }
    
    // Apply sign and check for overflow
    result *= sign
    
    // Check if result is within Int bounds
    if (result < Int.MinValue || result > Int.MaxValue) 0 else result.toInt
  }
}