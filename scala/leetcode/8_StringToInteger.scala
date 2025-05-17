object Solution {
    def myAtoi(s: String): Int = {
        if (s == null || s.isEmpty) return 0
        
        var index = 0
        val n = s.length
        
        // Step 1: Skip leading whitespace
        while (index < n && s(index) == ' ') {
            index += 1
        }
        
        if (index == n) return 0  // String contains only whitespace
        
        // Step 2: Check for sign
        var sign = 1
        if (s(index) == '-' || s(index) == '+') {
            sign = if (s(index) == '-') -1 else 1
            index += 1
        }
        
        // Step 3: Read digits and convert to integer
        var result: Long = 0
        while (index < n && s(index).isDigit) {
            val digit = s(index) - '0'
            
            // Check for overflow before adding the new digit
            if (result > (Int.MaxValue - digit) / 10) {
                // Will overflow
                return if (sign == 1) Int.MaxValue else Int.MinValue
            }
            
            result = result * 10 + digit
            index += 1
        }
        
        // Apply sign and check final boundaries
        result *= sign
        
        // Step 4: Return clamped result
        if (result > Int.MaxValue) Int.MaxValue
        else if (result < Int.MinValue) Int.MinValue
        else result.toInt
    }
}