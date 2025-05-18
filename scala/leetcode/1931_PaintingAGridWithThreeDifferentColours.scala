object Solution {
    def colorTheGrid(m: Int, n: Int): Int = {
        val MOD = 1000000007
        
        // Generate all valid colorings for a single column (no adjacent cells have same color)
        def generateValidColorings(): List[Int] = {
            val result = scala.collection.mutable.ListBuffer[Int]()
            
            def backtrack(pos: Int, coloring: Int, prevColor: Int): Unit = {
                if (pos == m) {
                    result += coloring
                    return
                }
                
                // Try each color (0, 1, 2)
                for (color <- 0 until 3) {
                    if (color != prevColor) {
                        // Encode the color at current position
                        backtrack(pos + 1, coloring | (color << (pos * 2)), color)
                    }
                }
            }
            
            backtrack(0, 0, -1)
            result.toList
        }
        
        // Check if two column colorings are compatible horizontally
        def areCompatible(coloring1: Int, coloring2: Int): Boolean = {
            (0 until m).forall { row =>
                val color1 = (coloring1 >> (row * 2)) & 3
                val color2 = (coloring2 >> (row * 2)) & 3
                color1 != color2
            }
        }
        
        // Generate all valid colorings for a single column
        val validColorings = generateValidColorings()
        val numColorings = validColorings.size
        
        // Create adjacency list of compatible next-column colorings
        val compatible = Array.ofDim[Array[Int]](numColorings)
        for (i <- 0 until numColorings) {
            compatible(i) = validColorings.indices
                .filter(j => areCompatible(validColorings(i), validColorings(j)))
                .toArray
        }
        
        // Dynamic programming
        var dp = Array.fill(numColorings)(1L)
        
        for (_ <- 1 until n) {
            val newDp = Array.fill(numColorings)(0L)
            
            for (i <- 0 until numColorings) {
                for (j <- compatible(i)) {
                    newDp(i) = (newDp(i) + dp(j)) % MOD
                }
            }
            
            dp = newDp
        }
        
        (dp.sum % MOD).toInt
    }
}