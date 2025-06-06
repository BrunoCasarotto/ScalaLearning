object Solution {
    def myAtoi(s: String): Int = {
        if (s == null || s.isEmpty) return 0
        
        var index = 0
        val n = s.length
        
        while (index < n && s(index) == ' ') {
            index += 1
        }
        
        if (index == n) return 0
        
        var sign = 1
        if (s(index) == '-' || s(index) == '+') {
            sign = if (s(index) == '-') -1 else 1
            index += 1
        }
        
        var result: Long = 0
        while (index < n && s(index).isDigit) {
            val digit = s(index) - '0'
            
            if (result > (Int.MaxValue - digit) / 10) {
                return if (sign == 1) Int.MaxValue else Int.MinValue
            }
            
            result = result * 10 + digit
            index += 1
        }
        
        result *= sign
        
        if (result > Int.MaxValue) Int.MaxValue
        else if (result < Int.MinValue) Int.MinValue
        else result.toInt
    }
}