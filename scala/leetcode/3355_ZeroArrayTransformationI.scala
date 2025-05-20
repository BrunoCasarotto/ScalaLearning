object Solution {
    def isZeroArray(nums: Array[Int], queries: Array[Array[Int]]): Boolean = {
        val n = nums.length
        val delta = Array.fill(n + 1)(0)

        // Process queries using difference array technique
        for (q <- queries) {
            val l = q(0)
            val r = q(1)
            delta(l) += 1
            if (r + 1 < n) delta(r + 1) -= 1
        }

        // Calculate running sum of differences
        val newDelta = Array.fill(n)(0)
        newDelta(0) = delta(0)
        for (i <- 1 until n) {
            newDelta(i) = newDelta(i - 1) + delta(i)
        }

        // Check if all elements can be reduced to zero
        (0 until n).forall(i => nums(i) - newDelta(i) <= 0)
    }
}