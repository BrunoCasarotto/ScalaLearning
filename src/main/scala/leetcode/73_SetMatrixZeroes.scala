object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        val m = matrix.length
        val n = matrix(0).length
        
        var firstRowHasZero = false
        var firstColHasZero = false
        
        for (j <- 0 until n) {
            if (matrix(0)(j) == 0) {
                firstRowHasZero = true
            }
        }
        
        for (i <- 0 until m) {
            if (matrix(i)(0) == 0) {
                firstColHasZero = true
            }
        }
        
        for (i <- 1 until m; j <- 1 until n) {
            if (matrix(i)(j) == 0) {
                matrix(i)(0) = 0
                matrix(0)(j) = 0
            }
        }
        
        for (i <- 1 until m; j <- 1 until n) {
            if (matrix(i)(0) == 0 || matrix(0)(j) == 0) {
                matrix(i)(j) = 0
            }
        }
        
        if (firstRowHasZero) {
            for (j <- 0 until n) {
                matrix(0)(j) = 0
            }
        }
        
        if (firstColHasZero) {
            for (i <- 0 until m) {
                matrix(i)(0) = 0
            }
        }
    }
}