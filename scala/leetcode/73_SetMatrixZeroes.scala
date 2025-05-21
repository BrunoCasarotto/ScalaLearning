object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        val m = matrix.length
        val n = matrix(0).length
        
        // Use first row and first column as markers
        // But first check if they originally contain zeros
        var firstRowHasZero = false
        var firstColHasZero = false
        
        // Check first row
        for (j <- 0 until n) {
            if (matrix(0)(j) == 0) {
                firstRowHasZero = true
            }
        }
        
        // Check first column
        for (i <- 0 until m) {
            if (matrix(i)(0) == 0) {
                firstColHasZero = true
            }
        }
        
        // Use first row and column as markers for zeros
        for (i <- 1 until m; j <- 1 until n) {
            if (matrix(i)(j) == 0) {
                matrix(i)(0) = 0 // Mark the row
                matrix(0)(j) = 0 // Mark the column
            }
        }
        
        // Set zeros based on markers (except first row and column)
        for (i <- 1 until m; j <- 1 until n) {
            if (matrix(i)(0) == 0 || matrix(0)(j) == 0) {
                matrix(i)(j) = 0
            }
        }
        
        // Set first row to zeros if needed
        if (firstRowHasZero) {
            for (j <- 0 until n) {
                matrix(0)(j) = 0
            }
        }
        
        // Set first column to zeros if needed
        if (firstColHasZero) {
            for (i <- 0 until m) {
                matrix(i)(0) = 0
            }
        }
    }
}