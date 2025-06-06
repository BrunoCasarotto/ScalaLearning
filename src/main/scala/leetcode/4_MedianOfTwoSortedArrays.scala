object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val (a, b) = if (nums1.length > nums2.length) (nums2, nums1) else (nums1, nums2)
        val total = a.length + b.length
        val half = total / 2

        var left = 0
        var right = a.length

        while (left <= right) {
            val midA = left + (right - left) / 2
            val midB = half - midA

            val leftA = if (midA == 0) Int.MinValue else a(midA - 1)
            val rightA = if (midA == a.length) Int.MaxValue else a(midA)

            val leftB = if (midB == 0) Int.MinValue else b(midB - 1)
            val rightB = if (midB == b.length) Int.MaxValue else b(midB)

            if (leftA <= rightB && leftB <= rightA) {
                return if (total % 2 == 0) {
                    (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0
                } else {
                    Math.min(rightA, rightB).toDouble
                }
            } else if (leftA > rightB) {
                right = midA - 1
            } else {
                left = midA + 1
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted")
    }
}