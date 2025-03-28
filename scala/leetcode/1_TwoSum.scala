object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val numToIndex = scala.collection.mutable.Map[Int, Int]()

        for (i <- nums.indices) {
            val complement = target - nums(i)
            if (numToIndex.contains(complement)) {
                return Array(numToIndex(complement), i)
            }
            numToIndex(nums(i)) = i
        }
        Array()
    }
}