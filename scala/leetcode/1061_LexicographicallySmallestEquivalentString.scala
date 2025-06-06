object Solution {
    def smallestEquivalentString(s1: String, s2: String, baseStr: String): String = {
        val parent = Array.tabulate(26)(i => i)
        
        def find(x: Int): Int = {
            if (parent(x) != x) {
                parent(x) = find(parent(x))
            }
            parent(x)
        }
        
        def union(x: Int, y: Int): Unit = {
            val rootX = find(x)
            val rootY = find(y)
            
            if (rootX != rootY) {
                if (rootX < rootY) {
                    parent(rootY) = rootX
                } else {
                    parent(rootX) = rootY
                }
            }
        }
        
        for (i <- s1.indices) {
            val char1 = s1(i) - 'a'
            val char2 = s2(i) - 'a'
            union(char1, char2)
        }
        
        baseStr.map { char =>
            val charIndex = char - 'a'
            val root = find(charIndex)
            (root + 'a').toChar
        }.mkString
    }
}