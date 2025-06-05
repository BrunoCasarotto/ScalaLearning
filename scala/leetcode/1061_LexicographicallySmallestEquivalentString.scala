object Solution {
    def smallestEquivalentString(s1: String, s2: String, baseStr: String): String = {
        // Union-Find data structure
        val parent = Array.tabulate(26)(i => i) // parent[i] represents parent of character 'a' + i
        
        // Find with path compression
        def find(x: Int): Int = {
            if (parent(x) != x) {
                parent(x) = find(parent(x))
            }
            parent(x)
        }
        
        // Union two characters - always make the lexicographically smaller one the parent
        def union(x: Int, y: Int): Unit = {
            val rootX = find(x)
            val rootY = find(y)
            
            if (rootX != rootY) {
                // Make the smaller character the parent to ensure lexicographically smallest
                if (rootX < rootY) {
                    parent(rootY) = rootX
                } else {
                    parent(rootX) = rootY
                }
            }
        }
        
        // Build equivalence groups from s1 and s2
        for (i <- s1.indices) {
            val char1 = s1(i) - 'a'
            val char2 = s2(i) - 'a'
            union(char1, char2)
        }
        
        // For each character in baseStr, replace with the smallest equivalent character
        baseStr.map { char =>
            val charIndex = char - 'a'
            val root = find(charIndex)
            (root + 'a').toChar
        }.mkString
    }
}