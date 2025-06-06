object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        var left = 0
        var mid = 0
        var right = nums.length - 1 
        
        while (mid <= right) {
            nums(mid) match {
                case 0 =>
                    swap(nums, left, mid)
                    left += 1
                    mid += 1
                case 1 =>
                    mid += 1
                case 2 =>
                    swap(nums, mid, right)
                    right -= 1
            }
        }
    }
    
    private def swap(nums: Array[Int], i: Int, j: Int): Unit = {
        val temp = nums(i)
        nums(i) = nums(j)
        nums(j) = temp
    }
}