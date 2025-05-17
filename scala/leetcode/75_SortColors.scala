object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        // Dutch National Flag algorithm
        // Use three pointers: left, mid, and right
        var left = 0          // for 0s (red)
        var mid = 0           // current position
        var right = nums.length - 1  // for 2s (blue)
        
        while (mid <= right) {
            nums(mid) match {
                case 0 => // Red
                    // Swap with left pointer and advance both left and mid
                    swap(nums, left, mid)
                    left += 1
                    mid += 1
                case 1 => // White
                    // Just advance mid pointer
                    mid += 1
                case 2 => // Blue
                    // Swap with right pointer and decrease right
                    // Don't increment mid yet as we need to check the swapped value
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