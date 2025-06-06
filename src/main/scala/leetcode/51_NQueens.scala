object Solution {
    def solveNQueens(n: Int): List[List[String]] = {
        var result = List[List[String]]()
        
        def isValid(board: Array[Int], row: Int, col: Int): Boolean = {
            (0 until row).forall { i =>
                board(i) != col && 
                Math.abs(board(i) - col) != Math.abs(i - row)
            }
        }
        
        def generateBoard(board: Array[Int]): List[String] = {
            board.map { col =>
                val sb = new StringBuilder()
                for (c <- 0 until n) {
                    if (c == col) sb.append('Q') else sb.append('.')
                }
                sb.toString
            }.toList
        }
        
        def backtrack(row: Int, board: Array[Int]): Unit = {
            if (row == n) {
                result = generateBoard(board) :: result
            } else {
                for (col <- 0 until n) {
                    if (isValid(board, row, col)) {
                        board(row) = col
                        backtrack(row + 1, board)
                    }
                }
            }
        }
        
        backtrack(0, Array.fill(n)(-1))
        
        result
    }
}