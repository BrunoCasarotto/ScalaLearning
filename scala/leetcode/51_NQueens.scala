object Solution {
    def solveNQueens(n: Int): List[List[String]] = {
        var result = List[List[String]]()
        
        // Helper function to check if a position is valid for queen placement
        def isValid(board: Array[Int], row: Int, col: Int): Boolean = {
            (0 until row).forall { i =>
                // Check if NOT same column and NOT on diagonal
                board(i) != col && 
                Math.abs(board(i) - col) != Math.abs(i - row)
            }
        }
        
        // Convert board representation to required output format
        def generateBoard(board: Array[Int]): List[String] = {
            board.map { col =>
                val sb = new StringBuilder()
                for (c <- 0 until n) {
                    if (c == col) sb.append('Q') else sb.append('.')
                }
                sb.toString
            }.toList
        }
        
        // Backtracking function
        def backtrack(row: Int, board: Array[Int]): Unit = {
            if (row == n) {
                // Found a valid solution
                result = generateBoard(board) :: result
            } else {
                // Try placing queen in each column of current row
                for (col <- 0 until n) {
                    if (isValid(board, row, col)) {
                        board(row) = col
                        backtrack(row + 1, board)
                        // No need to explicitly backtrack as we'll overwrite in next iteration
                    }
                }
            }
        }
        
        // Start backtracking from first row with empty board
        backtrack(0, Array.fill(n)(-1))
        
        result
    }
}