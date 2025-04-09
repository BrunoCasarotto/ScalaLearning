object Solution {
    def minOperations(nums: Array[Int], k: Int): Int = {
        if (nums.exists(_ < k)) return -1
        
        if (nums.forall(_ == k)) return 0
        
        val distinctValuesGreaterThanK = nums.filter(_ > k).distinct.size
        
        distinctValuesGreaterThanK
    }
}