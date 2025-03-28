object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var maxLength = 0
        var start = 0
        val charIndexMap = scala.collection.mutable.Map[Char, Int]()

        for (i <- s.indices) {
            val char = s(i)
            if (charIndexMap.contains(char)) {
                start = math.max(start, charIndexMap(s(i)) + 1)
            }
            charIndexMap(s(i)) = i
            maxLength = math.max(maxLength, i - start + 1)
        }

        maxLength
    }
}