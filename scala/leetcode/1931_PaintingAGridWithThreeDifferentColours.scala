object Solution {
    def colorTheGrid(m: Int, n: Int): Int = {
        val MOD = 1000000007
        
        def generateValidColorings(): List[Int] = {
            val result = scala.collection.mutable.ListBuffer[Int]()
            
            def backtrack(pos: Int, coloring: Int, prevColor: Int): Unit = {
                if (pos == m) {
                    result += coloring
                    return
                }
                
                for (color <- 0 until 3) {
                    if (color != prevColor) {
                        backtrack(pos + 1, coloring | (color << (pos * 2)), color)
                    }
                }
            }
            
            backtrack(0, 0, -1)
            result.toList
        }
        
        def areCompatible(coloring1: Int, coloring2: Int): Boolean = {
            (0 until m).forall { row =>
                val color1 = (coloring1 >> (row * 2)) & 3
                val color2 = (coloring2 >> (row * 2)) & 3
                color1 != color2
            }
        }
        
        val validColorings = generateValidColorings()
        val numColorings = validColorings.size
        
        val compatible = Array.ofDim[Array[Int]](numColorings)
        for (i <- 0 until numColorings) {
            compatible(i) = validColorings.indices
                .filter(j => areCompatible(validColorings(i), validColorings(j)))
                .toArray
        }
        
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