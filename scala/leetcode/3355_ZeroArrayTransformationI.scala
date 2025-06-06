object Solution {
    def isZeroArray(nums: Array[Int], queries: Array[Array[Int]]): Boolean = {
        val n = nums.length
        val delta = Array.fill(n + 1)(0)

        for (q <- queries) {
            val l = q(0)
            val r = q(1)
            delta(l) += 1
            if (r + 1 < n) delta(r + 1) -= 1
        }

        val newDelta = Array.fill(n)(0)
        newDelta(0) = delta(0)
        for (i <- 1 until n) {
            newDelta(i) = newDelta(i - 1) + delta(i)
        }

        (0 until n).forall(i => nums(i) - newDelta(i) <= 0)
    }
}