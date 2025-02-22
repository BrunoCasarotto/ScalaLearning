object LearnScala {

    def main(args: Array[String]): Unit = {
        println("Start")
        println("--------------------")

        val sum = sumOfSquares(3, 4)
        println(sum)
        println("--------------------")

        val sumShort = sumOfSquaresShort(5, 5)
        println(sumShort)
        println("--------------------")

        val anonymous = anonymousFunction(6)
        println(anonymous)
        println("--------------------")

        val sq: Int => Int = x => x * x
        println(sq(10))
        println("--------------------")

        val addOne: Int => Int = _ + 1
        println(addOne(5))
        println("--------------------")

        val weirdSum: (Int, Int) => Int = (_ * 2 + _ * 3)
        println(weirdSum(2, 3))
        println("--------------------")
    }

    def sumOfSquares(x: Int, y: Int): Int = {
        val x2 = x * x
        val y2 = y * y
        x2 + y2
    }

    def sumOfSquaresShort(x: Int, y: Int): Int = x * x + y * y

    def anonymousFunction(x: Int): Int = x * x

    
}