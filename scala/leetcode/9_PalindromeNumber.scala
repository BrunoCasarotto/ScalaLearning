object Solution {
    def isPalindrome(x: Int): Boolean = {
        // Negative numbers are not palindromes due to the minus sign
        if (x < 0) return false
        
        // Single digit numbers are always palindromes
        if (x < 10) return true
        
        // Numbers ending with 0 are only palindromes if they are 0
        // (since no number can start with 0)
        if (x % 10 == 0 && x != 0) return false
        
        // Reverse half of the number
        var original = x
        var reversed = 0
        
        // We only need to reverse half the digits
        // When reversed becomes >= the remaining original, we've reached the middle
        while (original > reversed) {
            reversed = reversed * 10 + original % 10
            original /= 10
        }
        
        // For even number of digits: original == reversed
        // For odd number of digits: original == reversed/10 (to ignore the middle digit)
        original == reversed || original == reversed / 10
    }
}