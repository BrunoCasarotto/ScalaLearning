object HelloWorld {
    def main(args: Array[String]): Unit = {
        println("Start")
        println("--------------------")
        
        val sum = sumOfSquares(3, 4)
        println(sum)
        println("--------------------")

        val sumShort = sumOfSquaresShort(5, 5)
        println(sumShort)
        println("--------------------")
    }

    def sumOfSquares(x: Int, y: Int): Int = {
        val x2 = x * x
        val y2 = y * y
        x2 + y2
    }

    def sumOfSquaresShort (x: Int, y: Int): Int = x * x + y * y
}