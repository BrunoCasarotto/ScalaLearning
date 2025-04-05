object Solution {
    def convert(s: String, numRows: Int): String = {
        if (numRows == 1 || numRows >= s.length) return s
    
        val charsPerRow = new Array[Int](numRows)
        val cycleLen = 2 * numRows - 2
        
        for (i <- 0 until s.length) {
        val pos = i % cycleLen
        val row = if (pos < numRows) pos else cycleLen - pos
        charsPerRow(row) += 1
        }
        
        val rows = Array.tabulate(numRows)(i => new StringBuilder(charsPerRow(i)))
        
        var index = 0
        while (index < s.length) {
        val pos = index % cycleLen
        val row = if (pos < numRows) pos else cycleLen - pos
        rows(row).append(s(index))
        index += 1
        }

        val result = new StringBuilder(s.length)
        rows.foreach(result.append)
        result.toString
    }
}