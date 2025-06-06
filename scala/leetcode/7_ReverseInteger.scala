object Solution {
  def reverse(x: Int): Int = {
    if (x == 0) return 0
    
    val sign = if (x < 0) -1 else 1
    
    var num = math.abs(x.toLong)
    var result: Long = 0
    
    while (num > 0) {
      if (result > Int.MaxValue / 10) return 0
      
      result = result * 10 + (num % 10)
      num /= 10
    }
    
    result *= sign
    
    if (result < Int.MinValue || result > Int.MaxValue) 0 else result.toInt
  }
}