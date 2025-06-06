object Solution {
    def robotWithString(s: String): String = {
        val n = s.length
        
        val minSuffix = Array.fill(n)('z')
        minSuffix(n - 1) = s(n - 1)
        for (i <- n - 2 to 0 by -1) {
            minSuffix(i) = s(i).min(minSuffix(i + 1))
        }
        
        val result = new StringBuilder
        val stack = scala.collection.mutable.Stack[Char]()
        var i = 0
        
        while (i < n || stack.nonEmpty) {
            while (stack.nonEmpty && (i >= n || stack.top <= minSuffix(i))) {
                result.append(stack.pop())
            }
            
            if (i < n) {
                stack.push(s(i))
                i += 1
            }
        }
        
        result.toString
    }
}